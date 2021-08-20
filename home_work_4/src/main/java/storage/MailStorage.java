package storage;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class MailStorage {

    private final static MailStorage instance = new MailStorage();

    private final Map<String, Integer> massages;
    private final Map<String, String> users;
    private final Map<String, String> firstName;
    private final Map<String, String> lastName;
    private final Map<String, String> middleName;

    private final Map<String, String> birthday;


    private MailStorage() {
        this.massages = new HashMap<>();
        this.users = new HashMap<>();
        this.firstName = new HashMap<>();
        this.lastName = new HashMap<>();
        this.birthday = new HashMap<>();
        this.middleName = new HashMap<>();
    }

    public Map<String, String> getMiddleName() {
        return middleName;
    }

    public Map<String, Integer> getMassages() {
        return massages;
    }

    public Map<String, String> getUsers() {
        return users;
    }

    public Map<String, String> getFirstName() {
        return firstName;
    }

    public Map<String, String> getLastName() {
        return lastName;
    }

    public Map<String, String> getBirthday() {
        return birthday;
    }

    public static MailStorage getInstance() {
        return instance;
    }
}
