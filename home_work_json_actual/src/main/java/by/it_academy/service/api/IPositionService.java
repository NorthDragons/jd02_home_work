package by.it_academy.service.api;

import by.it_academy.model.Position;

import java.util.Collection;

public interface IPositionService {
    Long putPosition(Position position);

    Long updatePosition(Position position);

    Position getPosition(Long id);

    Collection<Position> getAllPosition(Long limit, Long page);

    String getPosName(Position position);

    Long getMaxPage(Long limit);
}
