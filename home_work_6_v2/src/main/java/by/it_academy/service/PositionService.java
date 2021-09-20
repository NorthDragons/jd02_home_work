package by.it_academy.service;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Position;
import by.it_academy.service.api.IPositionService;
import by.it_academy.storage.PositionStorage;

import java.util.Collection;

public class PositionService implements IPositionService {
    private static final PositionService instance = new PositionService();
    private final PositionStorage positionStorage;

    public PositionService() {
        positionStorage = PositionStorage.getInstance();
    }

    public static PositionService getInstance() {
        return instance;
    }

    @Override
    public void putPosition(Position position) {
        positionStorage.putPosition(position);
    }

    @Override
    public Position getPosition(Long id) {
        return positionStorage.getPosition(id);
    }

    @Override
    public Collection<Position> getAllPosition() {
        return positionStorage.getAllPosition();
    }

    @Override
    public String getPosName(Position position) {
        return positionStorage.getPosName(position);
    }

    @Override
    public Long getPosId(Position position) {
        return positionStorage.getPosId(position);
    }
}
