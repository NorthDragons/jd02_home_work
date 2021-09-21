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
    private final EmployeeService service;

    public HEmployeeHelper() {
        service = EmployeeService.getInstance();
    }

    public Employee onceGetMapping(ResultSet resultSet) {
        Employee employee = new Employee();
        try {

        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка RESULT_MAPPING", e);
        }
        return employee;
    }

    public List<Employee> allGetMapping(ResultSet resultSet) {
        List<Employee> employees = new ArrayList<>();
        try {


        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка ALL_RESULT_MAPPING", e);
        }
        return employees;
    }

    public static HEmployeeHelper getInstance() {
        return instance;
    }

}
