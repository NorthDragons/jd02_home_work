package service;/* created by Kaminskii Ivan
*/

import model.Message;
import model.User;
import service.api.IMessageService;
import storage.ChatsStorage;
import storage.api.IChatStorage;

import java.util.List;

public class MailMessageService implements IMessageService {
   private static final MailMessageService instance=new MailMessageService();
    private final IChatStorage storage;

    public MailMessageService() {
        this.storage= ChatsStorage.getInstance();
    }

    @Override
    public List<Message> get(User currentUser) {
        return this.storage.get(currentUser.getLogin());
    }

    @Override
    public void addSystemMessage(String loginRecipient, String message) {

    }

    @Override
    public void addMessage(String loginRecipient, Message message) {
        this.storage.addMessage(loginRecipient,message);
    }

    @Override
    public void addMessage(User recipient, Message message) {
        String login = recipient.getLogin();
        addMessage(login,message);
    }

    public static MailMessageService getInstance() {
        return instance;
    }
}
