package by.it_academy.storage.sql;/* created by Kaminskii Ivan
 */

import by.it_academy.model.sql.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestEmploeeStorage {
    private static final TestEmploeeStorage instance = new TestEmploeeStorage();
    private static DBInitializer dbInitializer;

    public TestEmploeeStorage() {
        dbInitializer = DBInitializer.getInstance();
    }

    public Collection<Employee> getAllEmploee() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = dbInitializer.getCpds().getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT employers.id, employers.name, employers.salary" +
                     " FROM application.employers ORDER BY id ASC" +
                "LIMIT ? OFFSET ?");) {
            statement.setLong(1, 10);
            statement.setLong(2, 20);
            statement.executeUpdate();

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setId(resultSet.getLong(1));
                    employee.setName(resultSet.getString(2));
                    employee.setSalary(resultSet.getDouble(3));
                    employees.add(employee);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }


    public static TestEmploeeStorage getInstance() {
        return instance;
    }
}
