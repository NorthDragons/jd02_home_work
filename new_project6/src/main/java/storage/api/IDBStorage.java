package storage.api;

public interface IDBStorage {
    void putUser(String name, Double salary);
    String getUserName();
    String getUserSalary();

}
