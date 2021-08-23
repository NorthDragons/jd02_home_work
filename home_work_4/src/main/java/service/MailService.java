package service;/* created by Kaminskii Ivan
 */

import model.UserDto;
import storage.UserStorage;

import java.time.LocalDate;
import java.util.Collection;

public class MailService {
    private final static MailService instance = new MailService();
    private final UserStorage storage;


    public MailService() {
        this.storage = UserStorage.getInstance();
    }

    public Collection<UserDto> getAll() {
        return this.storage.getAll();
    }

    public void signUp(UserDto user) {
        user.setRegistration(LocalDate.now());
        this.storage.add(user);
    }
    public UserDto get(String login) {
        return this.storage.get(login);
    }


    public static MailService getInstance() {
        return instance;
    }
}
