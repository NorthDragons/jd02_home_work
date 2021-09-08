package storage;/* created by Kaminskii Ivan
 */

import model.Employer;
import storage.api.IDBStorage;

import java.sql.*;

public class DBStorage implements IDBStorage {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Ошибка загрузки драйвера", e);
        }
    }
    private static final DBStorage instance = new DBStorage();
    private static Employer employer;

    public DBStorage() {
        employer = Employer.getInstance();
    }

    @Override
    public void putUser(Employer employer) {
        try (Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/crm",
                "postgres", "password")) {

            String name = employer.getName();
            double salary = employer.getSalary();

            try(PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO application.employers(\n"+
                    "name, salary)\n"+
                    "VALUES(?,?);", Statement.RETURN_GENERATED_KEYS)
            ){
                preparedStatement.setString(1,name);
                preparedStatement.setDouble(2,salary);

                preparedStatement.executeUpdate();
                try (ResultSet generatedKeys= preparedStatement.getGeneratedKeys()){
                    while (generatedKeys.next()){
                        employer.setId(generatedKeys.getLong(1));
                    }
                }
            }




            Statement statement = con.createStatement();
//            try (
//            ResultSet resultSet = statement.executeUpdate("INSERT INTO application.employers(\n" + "\tname, salary" +
//                    "\tVALUES ('" + name + "'," + salary + ");");) {
//
//            }
//            statement.executeUpdate("INSERT INTO application.employers(\n" + "\tname, salary" +
//                    "\tVALUES ('" + name + "'," + salary + ");");

            try (ResultSet resultSet = statement.executeQuery("SELECT id, name, salary FROM application.employers ORDER BY id ASC")) {
                System.out.print("id\tИмя\tЗарплата\n");
                while (resultSet.next()) {
                    System.out.printf("%d\t%s\t%,.2f\n",
                            resultSet.getLong(1),
                            resultSet.getString(2),
                            resultSet.getDouble(3));
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

    public static DBStorage getInstance() {
        return instance;
    }
}
