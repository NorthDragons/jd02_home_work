package it_academy.service.hibernate;/* created by Kaminskii Ivan
 */

import it_academy.model.Position;
import it_academy.service.api.IPosService;
import it_academy.storage.api.IEmpStorage;
import it_academy.storage.api.IPosStorage;
import it_academy.storage.hibernate.PositionStorageH;
import org.hibernate.SessionFactory;

import java.util.Collection;

public class PositionServiceH implements IPosService {
    private final IPosStorage positionStorageH;


    public PositionServiceH(IPosStorage positionStorageH) {
        this.positionStorageH = positionStorageH;

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
