package service.api;

import model.Message;
import model.User;

import java.util.List;

public interface IMessageService {
    List<Message> get(User currentUser);

    void addSystemMessage(String loginRecipient, String message);

    void addMessage(String loginRecipient, Message message);

    void addMessage(User recipient, Message message);
}
