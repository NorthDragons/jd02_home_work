package by.it_academy.service.api;

import by.it_academy.model.sql.Position;

import java.util.Collection;

public interface IPositionService {
    Long putPosition(Position position);

    Long updatePosition(Position position);

    Position getPosition(Long id);

    Collection<Position> getAllPosition(Long limit, Long offset);

    String getPosName(Position position);

    Long getPosId(Position position);

    Long getOffset(Long page, Long limit);

    Long getMaxPage(Long limit);
}
