package storage.api;

import model.User;

public interface IUserStorage {

    User get(String login);
    void add(User user);
}
