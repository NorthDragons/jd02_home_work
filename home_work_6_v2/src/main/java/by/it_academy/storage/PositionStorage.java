package by.it_academy.storage;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Position;
import by.it_academy.storage.api.IPositionStorage;

import java.sql.*;

public class PositionStorage implements IPositionStorage {
    DBInitializer dbInitializer;

    public PositionStorage() {
        this.dbInitializer = DBInitializer.getInstance();
    }

    @Override
    public void putPosition(Position position) {
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("INSERT INTO application.positions(\n" +
                                 "name)\n" +
                                 "VALUES(?);", Statement.RETURN_GENERATED_KEYS)
            ) {
                preparedStatement.setString(1, position.getName());
                preparedStatement.executeUpdate();

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    while (generatedKeys.next()) {
                        position.setId(generatedKeys.getLong(1));
                    }

                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка сохранения работника", e);
        }
    }

    @Override
    public Position getPosition(Long id) {
        Position position = new Position();
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("SELECT positions.id positions.name" +
                    " FROM application.positions WHERE id=" + id)) {
                position.setId(resultSet.getLong(1));
                position.setName(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
