package by.it_academy;/* created by Kaminskii Ivan
 */

import by.it_academy.storage.sql.CreatDB;
import by.it_academy.storage.sql.DBInitializer;
import by.it_academy.storage.api.DBCreator;

public class Main {
    private static final DBInitializer dbInitializer = DBInitializer.getInstance();

    public static void main(String[] args) {
        DBCreator dbCreator = new CreatDB();

//        dbCreator.newDB("name");
        dbCreator.depTable();
        dbCreator.posTable();
        dbCreator.empTable();

//        try (Connection connection =dbInitializer.getCpds().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, salary FROM application.employers ORDER BY id ASC LIMIT ? OFFSET ?")) {
//            preparedStatement.setLong(1,1);
//            preparedStatement.setLong(2,1);
//            try (ResultSet resultSet= preparedStatement.executeQuery()) {
//                while (resultSet.next()){
//                    System.out.println(resultSet.getLong(1) + resultSet.getString(2)+ resultSet.getDouble(3));
//                }
//
//            }
//        } catch (SQLException e) {
//            throw new IllegalStateException("Ошибка рабоыт с БД ", e);
//        }
    }
}
