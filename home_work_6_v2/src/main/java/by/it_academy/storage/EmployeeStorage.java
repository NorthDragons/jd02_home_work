package by.it_academy.storage;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Employee;
import by.it_academy.service.EmployeeService;
import by.it_academy.service.HEmployeeHelper;
import by.it_academy.storage.api.IEmployerStorage;

import java.sql.*;
import java.util.Collection;
import java.util.List;

public class EmployeeStorage implements IEmployerStorage {
    private static final EmployeeStorage instance = new EmployeeStorage();
    private static DBInitializer dbInitializer;
    private static EmployeeService employeeService = new EmployeeService();

    public EmployeeStorage() {
        employeeService = EmployeeService.getInstance();
        dbInitializer = DBInitializer.getInstance();
    }

    public void putEmployer(Employee employer) {
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("INSERT INTO application.employers(\n" +
                                 "\tname, salary, \"position\", department)\n" +
                                 "\tVALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS)
            ) {
                preparedStatement.setString(1, employer.getName());
                preparedStatement.setDouble(2, employer.getSalary());
                preparedStatement.setLong(3, employeeService.getPosId(employer.getPosition()));
                preparedStatement.setLong(4, employeeService.getDepId(employer.getDepartment()));
                preparedStatement.executeUpdate();

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    while (generatedKeys.next()) {
                        employer.setId(generatedKeys.getLong(1));
                    }

                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка сохранения работника", e);
        }

    }

    @Override
    public Employee getEmployee(Long id) {
        Employee employer;
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("SELECT id, name, salary, \"position\", department\n" +
                    "\tFROM application.employers WHERE id=" + id)
            ) {
                employer = employeeService.onceMapping(resultSet);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка работы с базой данных", e);
        }
        return employer;
    }

    @Override
    public Collection<Employee> getAllEmployers() {
        List<Employee> employers;
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("SELECT id, name, salary, \"position\", department\n" +
                    "\tFROM application.employers;")) {
                HEmployeeHelper hEmploeeHelper = HEmployeeHelper.getInstance();
                employers = hEmploeeHelper.allGetMapping(resultSet);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка подключения к базе данных", e);
        }
        return employers;
    }

    public static EmployeeStorage getInstance() {
        return instance;
    }
}
