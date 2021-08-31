package storage.api;

import model.Message;

import java.util.List;

public interface IChatStorage {
    List<Message> getMessage(String login);

    void addMessage(String login, Message message);

}
