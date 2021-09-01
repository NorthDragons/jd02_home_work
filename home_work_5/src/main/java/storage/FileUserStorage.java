package storage;/* created by Kaminskii Ivan
 */

import model.User;
import storage.api.IUserStorage;

import java.io.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FileUserStorage implements IUserStorage {
    private static final FileUserStorage instance = new FileUserStorage();
    private static Map<String, User> users;

    @Override
    public User get(String login) {
        this.readAll();
        if (users != null) {
            if (users.containsKey(login)) {
                return users.get(login);
            } else {
                throw new IllegalArgumentException("Пользователя с таким логином не найдено");
            }
        }
        throw new IllegalArgumentException("Пользователя с таким логином не найдено");
    }

    @Override
    public void add(User user) {
        user.setRegistration(LocalDate.now());
        this.readAll();
        if (users != null) {
            if (users.containsKey(user.getLogin())) {
                throw new IllegalStateException("Пользователь с таким логином уже существует");
            }
            users.put(user.getLogin(), user);
        } else {
            users = new HashMap<>();
        }
        users.put(user.getLogin(), user);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\save\\user.ser"))) {
            objectOutputStream.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void readAll() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\save\\user.ser"))) {
            Object object = objectInputStream.readObject();
            if (object != null) {
                users = (Map<String, User>) object;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<User> getAll() {
        this.readAll();
        return users.values();
    }

    public static IUserStorage getInstance() {
        return instance;
    }
}
