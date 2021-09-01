package storage;/* created by Kaminskii Ivan
 */

import storage.api.IDBStorage;

import java.sql.*;

public class DBStorage implements IDBStorage {

    private static Long id;

    @Override
    public void putUser(String name, Double salary) {
        try (Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/crm",
                "postgres", "password")) {

            try (PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO application.employers(\n" +
                    "name, salary)\n" +
                    "VALUES(?,?);")
            ) {
                preparedStatement.setString(1, name);
                preparedStatement.setDouble(2, salary);

                preparedStatement.executeUpdate();
                try (ResultSet generatedKey = preparedStatement.getGeneratedKeys();){
                    while (generatedKey.next()){
                        id=generatedKey.getLong(1);
                    }

                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка работы с базой данных", e);
        }
    }

    @Override
    public String getUserName() {
        try (Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/crm",
                "postgres", "password")) {
            Statement statement = con.createStatement();

            try (ResultSet resultSet = statement.executeQuery("SELECT id, name, salary FROM application.employers ORDER BY id ASC")) {
                           return resultSet.getString(2);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка работы с базой данных", e);
        }
    }

    @Override
    public String getUserSalary() {
        try (Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/crm",
                "postgres", "password")) {
            Statement statement = con.createStatement();

            try (ResultSet resultSet = statement.executeQuery("SELECT id, name, salary FROM application.employers ORDER BY id ASC")) {
                return resultSet.getString(3);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка работы с базой данных", e);
        }
    }
}
