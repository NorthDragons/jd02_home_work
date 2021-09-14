package by.it_academy.storage;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.model.Employer;
import by.it_academy.model.Position;
import by.it_academy.storage.api.IEmployerStorage;

import java.sql.*;

public class EmployerStorage implements IEmployerStorage {
    private static EmployerStorage instance;
    private static DBInitializer dbInitializer;

    public EmployerStorage() {
        dbInitializer = DBInitializer.getInstance();
    }

    public void putEmployer(Employer employer) {
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
    public Employer getEmployer(Long id) {
        Employer employer = new Employer();
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("SELECT employers.id, employers.name, employers.salary," +
                    "position.name, department.name" +
                    "FROM application.employers\n" +
                    "\\n" +
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
            e.printStackTrace();
        }
        return employer;
    }

    public static EmployerStorage getInstance() {
        return instance;
    }
}
