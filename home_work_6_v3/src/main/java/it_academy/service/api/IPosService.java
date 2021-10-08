package it_academy.service.api;

import it_academy.model.Position;

import java.util.Collection;

public interface IPosService {
    Long putPosition(Position position);

    Position getPosition(Long id);

    Collection<Position> getAllPosition();

    String getPosName(Position position);

    Long getPosId(Position position);

    Long getOffset(Long page, Long limit);

    Long getMaxPage(Long limit);

}
