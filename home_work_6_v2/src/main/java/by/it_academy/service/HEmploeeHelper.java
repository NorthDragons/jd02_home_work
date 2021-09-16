package by.it_academy.service;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.model.Employee;
import by.it_academy.model.Position;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HEmploeeHelper {
    private static final HEmploeeHelper instance = new HEmploeeHelper();
    private static EmployeeService employeeService;

    public HEmploeeHelper() {
        employeeService = EmployeeService.getInstance();
    }

    public Employee onceMapping(ResultSet resultSet) {
        return null;
    }

    public List<Employee> allMapping(ResultSet resultSet) {
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
                position.setName(employeeService.getPosName(posId));
                employer.setPosition(position);

                Department department = new Department();
                Long depId = resultSet.getLong(5);
                department.setId(depId);
                department.setDName(employeeService.getDepName(depId));
                employer.setDepartment(department);

                employees.add(employer);
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка RESULT_MAPPING", e);
        }
        return employees;
    }

    public static HEmploeeHelper getInstance() {
        return instance;
    }

}
