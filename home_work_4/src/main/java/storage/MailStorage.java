package by.it_academy.home_work4.storage;

import java.util.HashMap;
import java.util.Map;

public class MailStorage {

    private final static MailStorage instance = new MailStorage();

    private final Map<String, Integer> massages;


    private MailStorage() {
        this.massages = new HashMap<>();
    }

    public Map<String, Integer> getMassages() {
        return massages;
    }

    public static MailStorage getInstance() {
        return instance;
    }
}
