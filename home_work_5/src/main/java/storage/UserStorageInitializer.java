package storage;/* created by Kaminskii Ivan
 */

import storage.api.IChatStorage;
import storage.api.IUserStorage;

public class UserStorageInitializer {
    private static EStorageType userType;

    public static synchronized void setStorageTipe(EStorageType userType) {
        if (userType != null) {
            UserStorageInitializer.userType = userType;
        } else {
            throw new IllegalStateException("Не получается поменять storage");
        }
    }

    public static IUserStorage getInstance() {
        if (userType == null) {
            throw new IllegalArgumentException("не передан тип хранения");
        }
        switch (userType) {
            case FILE:
                return FileUserStorage.getInstance();
            case MEMORY:
                return MemoryUserStorage.getInstance();
            default:
                throw new IllegalArgumentException("Тип хранения введён не правильно");
        }
    }
}
