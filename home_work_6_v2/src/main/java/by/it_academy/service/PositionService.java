package by.it_academy.service;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Position;
import by.it_academy.service.api.IPositionService;
import by.it_academy.storage.PositionStorage;

import java.util.Collection;

public class PositionService implements IPositionService {
    private static final PositionService instance = new PositionService();
    private static PositionStorage positionStorage;

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
    public String getPosName(Long id) {
        return positionStorage.getPosName(id);
    }
}
