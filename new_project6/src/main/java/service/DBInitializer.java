package service;/* created by Kaminskii Ivan
 */

import java.sql.*;

public class DBInitializer {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Ошибка загрузки драйвера", e);
        }
    }

    public static void main(String[] args) {


        try (Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/crm",
                "postgres", "password")) {

            String name = "Антон";
            Double salary = -1.0;

            try(PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO application.employers(\n"+
                    "name, salary)\n"+
                    "VALUES(?,?);")
            ){
                preparedStatement.setString(1,name);
                preparedStatement.setDouble(2,salary);

                preparedStatement.executeUpdate();
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


}


