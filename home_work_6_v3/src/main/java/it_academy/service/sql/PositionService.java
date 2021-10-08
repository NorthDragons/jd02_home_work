package it_academy.service.sql;/* created by Kaminskii Ivan
 */

import it_academy.model.Position;
import it_academy.service.api.IPosService;

import java.util.Collection;

public class PositionService implements IPosService {
    private static final PositionService instance= new PositionService();

    public static PositionService getInstance() {
        return instance;
    }

    @Override
    public Long putPosition(Position position) {
        return null;
    }

    @Override
    public Position getPosition(Long id) {
        return null;
    }

    @Override
    public Collection<Position> getAllPosition() {
        return null;
    }

    @Override
    public String getPosName(Position position) {
        return null;
    }

    @Override
    public Long getPosId(Position position) {
        return null;
    }

    @Override
    public Long getOffset(Long page, Long limit) {
        return null;
    }

    @Override
    public Long getMaxPage(Long limit) {
        return null;
    }
}
