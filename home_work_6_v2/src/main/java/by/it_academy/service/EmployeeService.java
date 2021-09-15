package by.it_academy.service;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Employee;
import by.it_academy.service.api.IEmployerService;
import by.it_academy.storage.EmployeeStorage;
import by.it_academy.storage.TestEmploeeStorage;

import java.util.Collection;

public class EmployeeService implements IEmployerService {
    private static final EmployeeService instance = new EmployeeService();
    private static EmployeeStorage storage;
    private static DepartmentService departmentService;
    private static PositionService positionService;
    private static TestEmploeeStorage testEmploeeStorage;

    public EmployeeService() {
        storage = EmployeeStorage.getInstance();
        departmentService = DepartmentService.getInstance();
        positionService = PositionService.getInstance();
        testEmploeeStorage = TestEmploeeStorage.getInstance();
    }


    public static EmployeeService getInstance() {
        return instance;
    }

    @Override
    public String getPosName(Long id) {
        return null;
    }

    @Override
    public String getDepName(Long id) {
        return departmentService.getDepName(id);
    }

    @Override
    public Collection<Employee> getAllEmp() {
        return storage.getAllEmployers();
    }

    @Override
    public Employee getEmp(Long id) {
        return storage.getEmployee(id);
    }
}
