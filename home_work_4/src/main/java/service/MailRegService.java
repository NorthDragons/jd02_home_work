package service;/* created by Kaminskii Ivan
 */

import model.User;
import storage.UserStorage;

import java.time.LocalDate;
import java.util.Collection;

public class MailRegService {
    private final static MailRegService instance = new MailRegService();
    private final UserStorage storage;


    public MailRegService() {
        this.storage = UserStorage.getInstance();
    }

    public Collection<User> getAll() {
        return this.storage.getAll();
    }

    public void signUp(User user) {
        user.setRegistration(LocalDate.now());
        this.storage.add(user);
    }
    public User get(String login) {
        return this.storage.get(login);
    }


    public static MailRegService getInstance() {
        return instance;
    }
}
