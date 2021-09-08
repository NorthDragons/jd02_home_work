package service;/* created by Kaminskii Ivan
 */

import model.Employer;
import service.api.IUserService;
import storage.DBStorage;
import storage.api.IDBStorage;

public class UserService implements IUserService {
    private static final UserService instance = new UserService();
    private static IDBStorage storage;

    public UserService() {
        storage= DBStorage.getInstance();
    }

    @Override
    public void putUser(Employer employer) {
        storage.putUser(employer);
    }

    public static UserService getInstance() {
        return instance;
    }
}
