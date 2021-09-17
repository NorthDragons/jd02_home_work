package by.it_academy.service;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.model.Employee;
import by.it_academy.model.Position;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HEmployeeHelper {
    private static final HEmployeeHelper instance = new HEmployeeHelper();
    private static EmployeeService service;

    public HEmployeeHelper() {
        service = EmployeeService.getInstance();
    }

    public Employee onceGetMapping(ResultSet resultSet) {
        Employee employee = new Employee();
        service = EmployeeService.getInstance();
        try {
            while (resultSet.next()) {
                employee.setId(resultSet.getLong(1));
                employee.setName(resultSet.getString(2));
                employee.setSalary(resultSet.getDouble(3));

                Position position = new Position();
                Long posId = resultSet.getLong(4);
                position.setId(posId);
                position.setName(service.getPosName(position));
                employee.setPosition(position);

                Department department = new Department();
                Long depId = resultSet.getLong(5);
                department.setId(depId);
                department.setDName(service.getDepName(department));
                employee.setDepartment(department);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка RESULT_MAPPING", e);
        }
        return employee;
    }

    public List<Employee> allGetMapping(ResultSet resultSet) {
        List<Employee> employees = new ArrayList<>();
        service = EmployeeService.getInstance();
        try {
            while (resultSet.next()) {
                Employee employer = new Employee();
                employer.setId(resultSet.getLong(1));
                employer.setName(resultSet.getString(2));
                employer.setSalary(resultSet.getDouble(3));

                Position position = new Position();
                Long posId = resultSet.getLong(4);
                position.setId(posId);

                String posName = service.getPosName(position);
                position.setName(posName);
                employer.setPosition(position);

                Department department = new Department();
                Long depId = resultSet.getLong(5);
                department.setId(depId);
                service = EmployeeService.getInstance();
                String depName = service.getDepName(department);
                department.setDName(depName);
                employer.setDepartment(department);

                employees.add(employer);
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка ALL_RESULT_MAPPING", e);
        }
        return employees;
    }

    public static HEmployeeHelper getInstance() {
        return instance;
    }

}
