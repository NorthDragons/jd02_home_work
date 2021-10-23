package by.it_academy.storage.hibernate;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Position;
import by.it_academy.storage.api.IPositionStorage;

import java.util.Collection;

public class PositionStorageH implements IPositionStorage {
    @Override
    public Long putPosition(Position position) {
        return null;
    }

    @Override
    public Long updatePosition(Position position) {
        return null;
    }

    @Override
    public Position getPosition(Long id) {
        return null;
    }

    @Override
    public Collection<Position> getAllPosition(Long limit, Long offset) {
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
