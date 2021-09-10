package by.it_academy.service;/* created by Kaminskii Ivan
 */

import by.it_academy.service.api.IService;
import by.it_academy.storage.EmployerStorage;

public class EmployerService implements IService {
    private static EmployerStorage storage;

    public EmployerService() {
        storage = EmployerStorage.getInstance();
    }

    @Override
    public void putSection(Object section) {

    }
}
