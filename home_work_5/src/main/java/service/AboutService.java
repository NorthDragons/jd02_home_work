package service;/* created by Kaminskii Ivan
 */

import service.api.IAboutService;
import storage.ChatStorageInitializer;
import storage.EStorageType;
import storage.UserStorageInitializer;

import java.time.LocalDateTime;

public class AboutService implements IAboutService {
    private static LocalDateTime startTimeDate;
    private static final AboutService instance = new AboutService();


    @Override
    public void setStartTime(LocalDateTime startTime) {
        startTimeDate = startTime;
    }

    @Override
    public LocalDateTime getStartTime() {
        return startTimeDate;
    }

    @Override
    public EStorageType getStorageType(String storage) {
        switch (storage) {
            case "user":
                return UserStorageInitializer.getStorageType();
            case "chat":
                return ChatStorageInitializer.getStorageType();
            default:
                throw new IllegalArgumentException("Нет такого объекта");
        }

    }

    public static AboutService getInstance() {
        return instance;
    }
}
