package by.it_academy.storage.api;

import by.it_academy.model.Position;

public interface IPositionStorage {
    void putPosition(Position position);
    Position getPosition(Long id);
}
