package service;/* created by Kaminskii Ivan
 */

import model.Employer;
import service.api.IUserService;
import storage.DBStorage;
import storage.api.IDBStorage;

public class EmployerService implements IUserService {
    private static final EmployerService instance = new EmployerService();
    private static IDBStorage storage;

    public EmployerService() {
        storage= DBStorage.getInstance();
    }

    @Override
    public void putUser(Employer employer) {
        storage.putUser(employer);
    }

    public static EmployerService getInstance() {
        return instance;
    }
}
