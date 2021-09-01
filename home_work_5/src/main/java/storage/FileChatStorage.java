package storage;/* created by Kaminskii Ivan
 */

import model.Message;
import storage.api.IChatStorage;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileChatStorage implements IChatStorage {
    private static final FileChatStorage instance = new FileChatStorage();
    private static Map<String, List<Message>> chat = new HashMap<>();


    public void getAll(){
        try (ObjectInputStream objectInputStream=new ObjectInputStream(
                new FileInputStream("D:\\save\\chats.ser"))){
                chat= (Map<String, List<Message>>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Message> getMessage(String login) {
        this.getAll();
        return chat.get(login);
    }

    @Override
    public void addMessage(String login, Message message) {
        this.getAll();
        List<Message> newMessage;
        if (chat.containsKey(login)) {
            newMessage = chat.get(login);
            newMessage.add(message);
        } else {
            newMessage = new ArrayList<>();
            chat.put(login, newMessage);
        }

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("D:\\save\\chats.ser"))) {
            objectOutputStream.writeObject(chat);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileChatStorage getInstance() {
        return instance;
    }
}
