package service;/* created by Kaminskii Ivan
 */


import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DBInitializer {


    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Ошибка загрузки драйвера", e);
        }
    }

    public static void main(String[] args) {

        List<String> names = new LinkedList<>();
        try (CSVReader objectInputStream = new CSVReader(new FileReader("D:\\error\\mine\\Java\\java ent\\tools\\names\\russian_names.txt"))) {
            List<String[]> s = objectInputStream.readAll();
            for (String[] strings : s) {
                names.add(Arrays.toString(strings).replaceAll("[^А-Яа-я]", ""));

            }
//            System.out.print(names);


        } catch (IOException e) {
            throw new IllegalArgumentException("не пошло", e);
        }


        try (Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/crm",
                "postgres", "password")) {
            for (int i = 0; i < 5; i++) {
                int name = (int) (Math.random() * names.size());
                double salary = Math.random() * 99999999.99 + 100.00;
                int dep = (int) (Math.random() * 4 + 1);
                int pos = (int) (Math.random() * 9 + 1);
                String nameString = names.get(name);

                try (PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO application.employers(\n" +
                        "name, salary, position, department)\n" +
                        "VALUES(?,?,?,?);", Statement.RETURN_GENERATED_KEYS)
                ) {
                    preparedStatement.setString(1, nameString);
                    preparedStatement.setDouble(2, salary);
                    preparedStatement.setInt(3, pos);
                    preparedStatement.setInt(4, dep);

                    preparedStatement.executeUpdate();
                    try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                        while (generatedKeys.next()) {
                            System.out.println(generatedKeys.getLong(1));
                        }
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


//                Statement statement = con.createStatement();
//            try (
//            ResultSet resultSet = statement.executeUpdate("INSERT INTO application.employers(\n" + "\tname, salary" +
//                    "\tVALUES ('" + name + "'," + salary + ");");) {
//
//            }
//            statement.executeUpdate("INSERT INTO application.employers(\n" + "\tname, salary" +
//                    "\tVALUES ('" + name + "'," + salary + ");");

//                try (ResultSet resultSet = statement.executeQuery("SELECT id, name, salary,position,department FROM application.employers ORDER BY id ASC")) {
//                    System.out.print("id\tИмя\tЗарплата\n");
//                    while (resultSet.next()) {
//                        System.out.printf("%d\t%s\t%,.2f\t%d\t%d\n",
//                                resultSet.getLong(1),
//                                resultSet.getString(2),
//                                resultSet.getDouble(3),
//                                resultSet.getInt(4),
//                                resultSet.getInt(5));
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            throw new IllegalArgumentException("Ошибка работы с базой данных", e);
//        }


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}