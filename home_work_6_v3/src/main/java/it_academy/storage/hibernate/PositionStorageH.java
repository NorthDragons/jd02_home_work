package it_academy.storage.hibernate;/* created by Kaminskii Ivan
 */

import it_academy.model.Position;
import it_academy.storage.api.IPosStorage;
import org.hibernate.SessionFactory;

import java.util.Collection;

public class PositionStorageH implements IPosStorage {
    private final SessionFactory sessionFactory;

    public PositionStorageH(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
    public Long getMaxPage(Long limit) {
        return null;
    }
}
