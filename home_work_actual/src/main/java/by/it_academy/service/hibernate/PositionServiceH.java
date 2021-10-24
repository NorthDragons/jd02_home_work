package by.it_academy.service.hibernate;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Position;
import by.it_academy.service.api.IPositionService;
import by.it_academy.storage.hibernate.PositionStorageH;

import java.util.Collection;

public class PositionServiceH implements IPositionService {
    private static final PositionServiceH instance = new PositionServiceH();
    private final PositionStorageH positionStorageH;

    public PositionServiceH() {
        this.positionStorageH = PositionStorageH.getInstance();
    }

    public static PositionServiceH getInstance() {
        return instance;
    }

    @Override
    public Long putPosition(Position position) {
        return positionStorageH.putPosition(position);
    }

    @Override
    public Long updatePosition(Position position) {
        return positionStorageH.updatePosition(position);
    }

    @Override
    public Position getPosition(Long id) {
        return positionStorageH.getPosition(id);
    }

    @Override
    public Collection<Position> getAllPosition(Long limit, Long offset) {
        return positionStorageH.getAllPosition(limit, offset);
    }

    @Override
    public String getPosName(Position position) {
        return positionStorageH.getPosName(position);
    }

    @Override
    public Long getOffset(Long page, Long limit) {
        if (page == 0) {
            return page;
        }
        return (page - 1L) * limit;
    }

    @Override
    public Long getMaxPage(Long limit) {
        return positionStorageH.getMaxPage(limit);
    }
}
