package storage;/* created by Kaminskii Ivan
 */

import model.Message;
import storage.api.IChatStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatsStorage implements IChatStorage {
    private final static ChatsStorage instance = new ChatsStorage();
    private final Map<String, List<Message>> chat = new HashMap<>();

    @Override
    public List<Message> get(String login) {
        return chat.get(login);
    }

    @Override
    public void addMessage(String login, Message message) {
        List<Message> newMessage;
        if (chat.containsKey(login)) {
            newMessage = this.chat.get(login);
        } else {
            newMessage = new ArrayList<>();
            this.chat.put(login, newMessage);
        }
        newMessage.add(message);
    }

    public static ChatsStorage getInstance() {
        return instance;
    }

}
