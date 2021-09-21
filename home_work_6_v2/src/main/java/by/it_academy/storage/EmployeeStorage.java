package by.it_academy.storage;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.model.Employee;
import by.it_academy.model.Position;
import by.it_academy.service.EmployeeService;
import by.it_academy.storage.api.IEmployerStorage;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class EmployeeStorage implements IEmployerStorage {
    private static final EmployeeStorage instance = new EmployeeStorage();
    private final DBInitializer dbInitializer;
    private final EmployeeService employeeService;

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
        Employee employee = new Employee();
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("SELECT employers.id, employers.name, employers.salary, employers.position, employers.department, positions.name, departments.name \n" +
                    "FROM application.employers \n" +
                    "\n" +
                    "JOIN application.positions\n" +
                    "ON employers.position=positions.id\n" +
                    "JOIN application.departments\n" +
                    "ON employers.department=departments.id\n" +
                    "WHERE employers.id=" + id)
            ) {
                while (resultSet.next()) {
                    employee.setId(resultSet.getLong(1));
                    employee.setName(resultSet.getString(2));
                    employee.setSalary(resultSet.getDouble(3));

                    Position position = new Position();
                    Long posId = resultSet.getLong(4);
                    position.setId(posId);
                    position.setName(resultSet.getString(6));
                    employee.setPosition(position);

                    Department department = new Department();
                    Long depId = resultSet.getLong(5);
                    department.setId(depId);
                    department.setName(resultSet.getString(7));
                    employee.setDepartment(department);
                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка работы с базой данных", e);
        }
        return employee;
    }

    @Override
    public Collection<Employee> getAllEmployers(Long limit, Long offset) {
        List<Employee> employees = new LinkedList<>();
        try (Connection connection = dbInitializer.getCpds().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT employers.id, employers.name, employers.salary,employers.position, employers.department, positions.name, departments.name\n" +
                     "FROM application.employers\n" +
                     "JOIN application.positions\n" +
                     "ON employers.position=positions.id\n" +
                     "JOIN application.departments\n" +
                     "ON employers.department=departments.id\n" +
                     "ORDER BY id ASC\n" +
                     "LIMIT ? OFFSET ?")) {
            preparedStatement.setLong(1, limit);
            preparedStatement.setLong(2, offset);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Employee employer = new Employee();
                    employer.setId(resultSet.getLong(1));
                    employer.setName(resultSet.getString(2));
                    employer.setSalary(resultSet.getDouble(3));

                    Position position = new Position();
                    Long posId = resultSet.getLong(4);
                    position.setId(posId);

                    position.setName(resultSet.getString(6));
                    employer.setPosition(position);

                    Department department = new Department();
                    Long depId = resultSet.getLong(5);
                    department.setId(depId);
                    department.setName(resultSet.getString(7));
                    employer.setDepartment(department);

                    employees.add(employer);
                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка подключения к базе данных", e);
        }
        return employees;
    }

    public static EmployeeStorage getInstance() {
        return instance;
    }
}
