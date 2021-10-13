package by.it_academy.service.sql;/* created by Kaminskii Ivan
 */

import by.it_academy.model.sql.Department;
import by.it_academy.model.sql.Employee;
import by.it_academy.model.sql.Position;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {
    private static final EmployeeMapper instance = new EmployeeMapper();
    private final EmployeeService service;

    public EmployeeMapper() {
        service = EmployeeService.getInstance();
    }

    public Employee onceGetMapping(ResultSet resultSet) {
        Employee employee = new Employee();
        try {
            if (resultSet.next()) {
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
            }else {
                throw new IllegalArgumentException("Сотрудника с таким Id не найдено");
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка RESULT_MAPPING", e);
        }
        return employee;
    }

    public List<Employee> allGetMapping(ResultSet resultSet) {
        List<Employee> employees = new ArrayList<>();
        try {
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
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка ALL_RESULT_MAPPING", e);
        }
        return employees;
    }

    public static EmployeeMapper getInstance() {
        return instance;
    }

}
