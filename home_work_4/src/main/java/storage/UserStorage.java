package storage;/* created by Kaminskii Ivan
 */

import model.UserDto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private final Map<String, UserDto> users = new HashMap<>();
    private final static UserStorage instance = new UserStorage();

    public UserStorage() {
    }

    public UserDto get(String login){
        return users.get(login);
    }

    public void add(UserDto user) {
        if(this.users.containsKey(user.getLogin())){
            throw new IllegalArgumentException("Пользователь с логином " + user.getLogin() + " уже сущуствует");
        }
        this.users.put(user.getLogin(), user);
    }


    public Collection<UserDto> getAll() {
        return this.users.values();
    }

    public static UserStorage getInstance() {
        return instance;
    }
}