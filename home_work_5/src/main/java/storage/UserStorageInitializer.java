package storage;/* created by Kaminskii Ivan
 */

import storage.api.IUserStorage;

public class UserStorageInitializer {
    private static EStorageType storageType;

    public static EStorageType getStorageType(){
        return storageType;
    }

    public static synchronized void setStorageType(EStorageType userType) {
        if (userType != null) {
            UserStorageInitializer.storageType = userType;
        } else {
            throw new IllegalStateException("Не получается поменять storage");
        }
    }

    public static IUserStorage getInstance() {
        if (storageType == null) {
            throw new IllegalArgumentException("не передан тип хранения");
        }
        switch (storageType) {
            case FILE:
                return FileUserStorage.getInstance();
            case MEMORY:
                return MemoryUserStorage.getInstance();
            default:
                throw new IllegalArgumentException("Тип хранения введён не правильно");
        }
    }
}
