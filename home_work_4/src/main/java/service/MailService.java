package service;/* created by Kaminskii Ivan
 */

import storage.MailStorage;

import java.util.Map;

public class MailService {
    private final static MailService instance = new MailService();
    private final MailStorage storage;


    public MailService() {
        this.storage = MailStorage.getInstance();
    }

    public void addUsers(String login, String password, String firstName,
                         String lastName,String middleName, String birthday) {
        this.storage.getUsers().putIfAbsent(login, password);
        this.storage.getBirthday().putIfAbsent(login, birthday);
        this.storage.getFirstName().putIfAbsent(login, firstName);
        this.storage.getLastName().putIfAbsent(login, lastName);
        this.storage.getMiddleName().putIfAbsent(login,middleName);
    }

    public Map<String, String> getUsersResult() {
        return this.storage.getUsers();
    }

    public static MailService getInstance() {
        return instance;
    }
}
