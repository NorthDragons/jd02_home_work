package by.it_academy.service.api;

import by.it_academy.model.Position;

import java.util.Collection;

public interface IPositionService {
    void putPosition(Position position);

    Position getPosition(Long id);

    Collection<Position> getAllPosition();

    String getPosName(Long id);
}