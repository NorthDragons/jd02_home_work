package it_academy.storage.sql;/* created by Kaminskii Ivan
 */

import it_academy.model.Department;
import it_academy.model.Employee;
import it_academy.model.Position;
import it_academy.service.sql.EmployeeMapper;
import it_academy.service.sql.EmployeeService;
import it_academy.storage.api.IEmpStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmployeeStorage implements IEmpStorage {
    private static final EmployeeStorage instance = new EmployeeStorage();
    private final DBInitializer dbInitializer;
    private final EmployeeService employeeService;

    public EmployeeStorage() {
        employeeService = EmployeeService.getInstance();
        dbInitializer = DBInitializer.getInstance();
    }

    public Long putEmployer(Employee employer) {
        Department department = employer.getDepartment();
        Position position = employer.getPosition();

        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("INSERT INTO application.employers(\n" +
                                 "\tname, salary, \"position\", department)\n" +
                                 "\tVALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS)
            ) {
                preparedStatement.setString(1, employer.getName());
                preparedStatement.setDouble(2, employer.getSalary());
                preparedStatement.setLong(3, position.getId());
                preparedStatement.setLong(4, department.getId());
                preparedStatement.executeUpdate();

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    generatedKeys.next();
                    employer.setId(generatedKeys.getLong(1));
                    return generatedKeys.getLong(1);
                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка сохранения работника", e);
        }

    }

    @Override
    public Collection<Employee> getEmployee(Long id) {
        Employee employee;
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("" +
                    "SELECT employers.id, employers.name, employers.salary," +
                    "       employers.position, employers.department, positions.name, departments.name \n" +
                    "  FROM application.employers \n" +
                    "\n" +
                    "JOIN application.positions\n" +
                    "ON employers.position=positions.id\n" +
                    "JOIN application.departments\n" +
                    "ON employers.department=departments.id\n" +
                    "WHERE employers.id=" + id)
            ) {
                EmployeeMapper employeeMapper = EmployeeMapper.getInstance();
                employee = employeeMapper.onceGetMapping(resultSet);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка работы с базой данных", e);
        }
        employees.add(employee);
        return employees;
    }

    @Override
    public Collection<Employee> getAllEmployers(Long limit, Long offset) {
        List<Employee> employees;
        try (Connection connection = dbInitializer.getCpds().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT employers.id, employers.name, employers.salary," +
                     "employers.position, employers.department, positions.name, departments.name\n" +
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
                EmployeeMapper employeeMapper = EmployeeMapper.getInstance();
                employees = employeeMapper.allGetMapping(resultSet);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка подключения к базе данных", e);
        }
        return employees;
    }

    @Override
    public Long getMaxPage(Long limit) {
        long maxPage = 0L;
        try (Connection connection = dbInitializer.getCpds().getConnection(); Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT COUNT(id)\n" +
                    "FROM application.employers")) {
                while (resultSet.next()) {
                    long allLine = resultSet.getLong(1);

                    float aFloat = ((float) allLine / (float) limit);
                    maxPage = (long) Math.ceil(aFloat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxPage;
    }

    @Override
    public Collection<Employee> getEmpByName(String name) {
        return null;
    }

    public static EmployeeStorage getInstance() {
        return instance;
    }
}
