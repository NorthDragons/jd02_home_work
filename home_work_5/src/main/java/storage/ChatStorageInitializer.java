package storage;/* created by Kaminskii Ivan
 */

import model.Message;
import storage.api.IChatStorage;

public class ChatStorageInitializer {
    private static EStorageType storageType;

    public static EStorageType getStorageType(){
        return storageType;
    }

    public static synchronized void setStorageType(EStorageType storageType) {
        if (storageType != null) {
            ChatStorageInitializer.storageType = storageType;
        } else {
            throw new IllegalStateException("Не получается поменять storage");
        }
    }

    public static IChatStorage getInstance() {
        if(storageType ==null){
            throw new IllegalArgumentException("не передан тип хранения");
        }
        switch (storageType) {
            case FILE:
                return FileChatStorage.getInstance();
            case MEMORY:
                return MemoryChatStorage.getInstance();
            default:
                throw new IllegalArgumentException("Тип хранения введён не правильно");
        }
    }
}
