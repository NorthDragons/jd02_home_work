package storage;/* created by Kaminskii Ivan
 */

import model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private final Map<String, User> users = new HashMap<>();
    private final static UserStorage instance = new UserStorage();

    public UserStorage() {
    }

    public User get(String login){
        return users.get(login);
    }

    public void add(User user) {
        if(this.users.containsKey(user.getLogin())){
            throw new IllegalArgumentException("Пользователь с логином " + user.getLogin() + " уже сущуствует");
        }
        this.users.put(user.getLogin(), user);
    }


    public Collection<User> getAll() {
        return this.users.values();
    }

    public static UserStorage getInstance() {
        return instance;
    }
}