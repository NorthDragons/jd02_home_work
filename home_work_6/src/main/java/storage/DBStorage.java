package storage;/* created by Kaminskii Ivan
 */

import model.Employer;
import storage.api.IDBStorage;

import javax.sql.DataSource;
import java.sql.*;

public class DBStorage implements IDBStorage {

    private static final DBStorage instance = new DBStorage();
    private final DataSource dataSource;
//    private static Employer employer;

    public DBStorage() {
//        employer = Employer.getInstance();
        dataSource = PooledDataStorage.getInstance();
    }

    @Override
    public void putUser(Employer employer) {
        try (Connection con = (Connection) dataSource) {

            String name = employer.getName();
            double salary = employer.getSalary();

            try (PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO application.employers(\n" +
                    "name, salary)\n" +
                    "VALUES(?,?);", Statement.RETURN_GENERATED_KEYS)
            ) {
                preparedStatement.setString(1, name);
                preparedStatement.setDouble(2, salary);
                preparedStatement.executeUpdate();
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    while (generatedKeys.next()) {
//                        employer.setId(generatedKeys.getLong(1));
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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

    public static DBStorage getInstance() {
        return instance;
    }
}
