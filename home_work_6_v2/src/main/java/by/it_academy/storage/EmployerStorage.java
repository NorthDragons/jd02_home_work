package by.it_academy.storage;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Employer;

import java.sql.*;

public class EmployerStorage {
    private static EmployerStorage instance;
    private static DBInitializer dbInitializer;

    public EmployerStorage() {
        dbInitializer = DBInitializer.getInstance();
    }

    public void putEmployers(Employer employer) {
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO application.employers(\n" +
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


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static EmployerStorage getInstance() {
        return instance;
    }
}
