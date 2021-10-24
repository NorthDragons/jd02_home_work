package by.it_academy.service.sql;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Position;
import by.it_academy.service.api.IPositionService;
import by.it_academy.storage.sql.PositionStorage;

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
    public Long putPosition(Position position) {
       return positionStorage.putPosition(position);
    }

    @Override
    public Long updatePosition(Position position) {
        return positionStorage.updatePosition(position);
    }

    @Override
    public Position getPosition(Long id) {
        return positionStorage.getPosition(id);
    }

    @Override
    public Collection<Position> getAllPosition(Long limit, Long offset) {
        return positionStorage.getAllPosition( limit,  offset);
    }

    @Override
    public String getPosName(Position position) {
        return positionStorage.getPosName(position);
    }



    @Override
    public Long getOffset(Long page, Long limit) {
        if(page==0){
            return page;
        }
        return (page - 1L) * limit;
    }

    @Override
    public Long getMaxPage(Long limit) {
        return positionStorage.getMaxPage(limit);
    }
}
