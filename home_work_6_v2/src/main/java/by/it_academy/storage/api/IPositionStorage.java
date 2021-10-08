package by.it_academy.storage.api;

import by.it_academy.model.sql.Position;

import java.util.Collection;

public interface IPositionStorage {
    Long putPosition(Position position);

    Position getPosition(Long id);

    Collection<Position> getAllPosition();

    String getPosName(Position position);

    Long getPosId(Position position);

    Long getMaxPage(Long limit);
}
