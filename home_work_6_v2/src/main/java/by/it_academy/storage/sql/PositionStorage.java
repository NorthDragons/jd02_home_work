package by.it_academy.storage.sql;/* created by Kaminskii Ivan
 */

import by.it_academy.model.sql.Position;
import by.it_academy.storage.api.IPositionStorage;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class PositionStorage implements IPositionStorage {
    private static final PositionStorage instance = new PositionStorage();
    private static DBInitializer dbInitializer;

    public PositionStorage() {
        dbInitializer = DBInitializer.getInstance();
    }

    @Override
    public Long putPosition(Position position) {
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
                    return position.getId();
                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка сохранения должности", e);
        }
    }

    @Override
    public Long updatePosition(Position position) {
        return null;
    }

    @Override
    public Position getPosition(Long id) {
        Position position = new Position();
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("SELECT id, name\n" +
                    " FROM application.positions WHERE id =" + id)) {
                while (resultSet.next()){
                    position.setId(resultSet.getLong(1));
                    position.setName(resultSet.getString(2));
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка работы с Базой Данных -POS", e);
        }

        return position;
    }

    @Override
    public Collection<Position> getAllPosition(Long limit, Long offset) {
        List<Position> positions = new LinkedList<>();
        try (Connection connection = dbInitializer.getCpds().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * \n" +
                     "FROM application.positions\n" +
                     "ORDER BY id ASC\n" +
                     "LIMIT ? OFFSET ?")) {
            preparedStatement.setLong(1, limit);
            preparedStatement.setLong(2, offset);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Position position = new Position();
                    position.setId(resultSet.getLong(1));
                    position.setName(resultSet.getString(2));
                    positions.add(position);
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка работы с Базой Данных -POS", e);
        }
        return positions;
    }

    @Override
    public String getPosName(Position position) {
        String name;
        if (position.getName() != null) {
            return position.getName();
        } else if (position.getId() != null) {
            Long id = position.getId();
            try (Connection connection = dbInitializer.getCpds().getConnection()) {
                Statement statement = connection.createStatement();
                try (ResultSet resultSet = statement.executeQuery("SELECT positions.name FROM application.positions WHERE id=" + id)) {
                    resultSet.next();
                    name = resultSet.getString(1);
                }
            } catch (SQLException e) {
                throw new IllegalStateException("Ошибка получения имени", e);
            }
            return name;
        } else {
            throw new IllegalArgumentException("Не задано обязательных параметров для получения Имени -POS");
        }
    }

    @Override
    public Long getPosId(Position position) {
        Long id;
        if (position.getId() != null) {
            id = position.getId();
        } else if (position.getName() != null) {
            try (Connection connection = dbInitializer.getCpds().getConnection()) {
                Statement statement = connection.createStatement();
                try (ResultSet resultSet = statement.executeQuery("SELECT id FROM application.positions WHERE name=" + position.getName())) {
                    resultSet.next();
                    id = resultSet.getLong(1);
                }
            } catch (SQLException e) {
                throw new IllegalStateException("Ошибка получения ID", e);
            }
        } else {
            throw new IllegalArgumentException("Не задано обязательного условия для получения ID -POS");
        }
        return id;
    }

    @Override
    public Long getMaxPage(Long limit) {
        long maxPage = 0L;
        try (Connection connection = dbInitializer.getCpds().getConnection(); Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT COUNT(id)\n" +
                    "FROM application.positions")) {
                while (resultSet.next()) {
                    long allLine = resultSet.getLong(1);

                    float aFloat = ((float) allLine / (float) limit);
                    maxPage = (long) Math.ceil(aFloat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxPage;
    }

    public static PositionStorage getInstance() {
        return instance;
    }
}
