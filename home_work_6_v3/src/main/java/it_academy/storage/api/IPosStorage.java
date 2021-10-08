package it_academy.storage.api;

import it_academy.model.Position;

import java.util.Collection;

public interface IPosStorage {
    Long putPosition(Position position);

    Position getPosition(Long id);

    Collection<Position> getAllPosition();

    String getPosName(Position position);

    Long getPosId(Position position);

    Long getMaxPage(Long limit);
}
