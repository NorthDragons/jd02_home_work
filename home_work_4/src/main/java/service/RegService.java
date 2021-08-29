package service;/* created by Kaminskii Ivan
 */

import model.User;
import storage.UserStorage;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class RegService {
    private final static RegService instance = new RegService();
    private final UserStorage storage;
    private static final String SEP = File.separator;


    public RegService() {
        this.storage = UserStorage.getInstance();
    }

    public Collection<User> getAll() {
        return this.storage.getAll();
    }

//    public void saveUsers(String login, User user) throws IOException, ClassNotFoundException {
//        Map<String, User> users = instance.getusers();
//        if (users.containsKey(login)) {
//            throw new IllegalArgumentException("Пользователь с таким логином уже существует");
//        }
//        user.setRegistration(LocalDate.now());
//        users.put(login, user);
//
//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
//                new FileOutputStream("D:" + SEP + "save" + SEP + "user.ser"))) {
//            objectOutputStream.writeObject(users);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public Map<String, User> getusers() {
//        Map<String, User> userMap = new HashMap<>();
//        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\save\\user.ser"))) {
//            userMap = (Map<String, User>) objectInputStream.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return userMap;
//    }

    public void signUp(User user) throws IOException {
//        user.setRegistration(LocalDate.now());
//        try {
//            saveUsers(user.getLogin(), user);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        this.storage.add(user);
    }

    public User get(String login) {
        return this.storage.get(login);
    }


    public static RegService getInstance() {
        return instance;
    }
}
