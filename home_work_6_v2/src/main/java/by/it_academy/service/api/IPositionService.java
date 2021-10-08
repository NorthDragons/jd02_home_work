package by.it_academy.service.api;

import by.it_academy.model.sql.Position;

import java.util.Collection;

public interface IPositionService {
    Long putPosition(Position position);

    Position getPosition(Long id);

    Collection<Position> getAllPosition();

    String getPosName(Position position);

    Long getPosId(Position position);

    Long getOffset(Long page, Long limit);

    Long getMaxPage(Long limit);
}
