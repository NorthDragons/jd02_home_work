package service.api;

import storage.EStorageType;

import java.time.LocalDateTime;

public interface IAboutService {
    void setStartTime(LocalDateTime startTime);
    LocalDateTime getStartTime();
    EStorageType getStorageType(String storage);

}
