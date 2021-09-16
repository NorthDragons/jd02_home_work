package by.it_academy.storage;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.model.Employee;
import by.it_academy.model.Position;
import by.it_academy.service.EmployeeService;
import by.it_academy.storage.api.IEmployerStorage;

import java.sql.*;
import java.util.Collection;
import java.util.List;

public class EmployeeStorage implements IEmployerStorage {
    private static final EmployeeStorage instance = new EmployeeStorage();
    private static DBInitializer dbInitializer;
    private static EmployeeService employerService;

    public EmployeeStorage() {
        employerService = EmployeeService.getInstance();
        dbInitializer = DBInitializer.getInstance();
    }

    public void putEmployer(Employee employer) {
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("INSERT INTO application.employers(\n" +
                                 "name, salary)\n" +
                                 "VALUES(?,?);", Statement.RETURN_GENERATED_KEYS)
            ) {
                preparedStatement.setString(1, employer.getName());
                preparedStatement.setDouble(2, employer.getSalary());
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
        Employee employer = new Employee();
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("SELECT employers.id, employers.name, employers.salary, positions.name, departments.name \n" +
                    "FROM application.employers \n" +
                    "\n" +
                    "JOIN application.positions\n" +
                    "ON employers.position=positions.id\n" +
                    "JOIN application.departments\n" +
                    "ON employers.department=departments.id\n" +
                    "WHERE employers.id=" + id)
            ) {
                while (resultSet.next()) {
                    Position position = new Position();
                    Department department = new Department();

                    position.setName(resultSet.getString(4));
                    department.setDName(resultSet.getString(5));

                    employer.setId(resultSet.getLong(1));
                    employer.setName(resultSet.getString(2));
                    employer.setSalary(resultSet.getDouble(3));
                    employer.setDepartment(department);
                    employer.setPosition(position);
                }
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
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM application.employers")) {
               employers=employerService.allMapping(resultSet);
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
