package service;/* created by Kaminskii Ivan
 */

import model.User;
import storage.UserStorageInitializer;
import storage.api.IUserStorage;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class RegService {
    private final static RegService instance = new RegService();
    private final IUserStorage storage;
    private static final String SEP = File.separator;


    public RegService() {
        this.storage = UserStorageInitializer.getInstance();
    }

    public Collection<User> getAll() {
        return this.storage.getAll();
    }

    public void signUp(User user) throws IOException {
        this.storage.add(user);
    }

    public User get(String login) {
        return this.storage.get(login);
    }


    public static RegService getInstance() {
        return instance;
    }
}
