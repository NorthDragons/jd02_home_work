package by.it_academy.home_work3.service.api;

public interface IStorage {

    String get(String key);

    void save(String key, String value);
}
