package storage;/* created by Kaminskii Ivan
 */

import storage.api.IChatStorage;

public class ChatStorageInitializer {
    private static EStorageType storageTipe;

    public static synchronized void setStorageTipe(EStorageType storageTipe) {
        if (storageTipe != null) {
            ChatStorageInitializer.storageTipe = storageTipe;
        } else {
            throw new IllegalStateException("Не получается поменять storage");
        }
    }

    public static IChatStorage getInstance() {
        if(storageTipe==null){
            throw new IllegalArgumentException("не передан тип хранения");
        }
        switch (storageTipe) {
            case FILE:
                return MemoryChatStorage.getInstance();
            case MEMORY:
                return FileChatStorage.getInstance();
            default:
                throw new IllegalArgumentException("Тип хранения введён не правильно");
        }
    }
}
