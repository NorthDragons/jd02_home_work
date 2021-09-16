package by.it_academy.storage.api;

import by.it_academy.model.Position;

import java.util.Collection;

public interface IPositionStorage {
    void putPosition(Position position);

    Position getPosition(Long id);

    Collection<Position> getAllPosition();

    String getPosName(Position position);

    Long getPosId(Position position);
}
