package storage.api;

import model.Employer;

public interface IDBStorage {
    void putUser(Employer employer);
    String getUserName();
    String getUserSalary();

}
