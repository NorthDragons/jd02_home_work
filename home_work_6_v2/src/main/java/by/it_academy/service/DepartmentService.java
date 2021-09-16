package by.it_academy.service;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.service.api.IDepartmentService;
import by.it_academy.storage.DepartmentStorage;

import java.util.Collection;

public class DepartmentService implements IDepartmentService {
    private static DepartmentStorage departmentStorage;

    public DepartmentService() {
        departmentStorage = DepartmentStorage.getInstance();
    }

    private static final DepartmentService instance = new DepartmentService();

    public static DepartmentService getInstance() {
        return instance;
    }

    @Override
    public void putDepartment(Department department, Long parentId) {
        departmentStorage.putDepartment(department, parentId);

    }

    @Override
    public Collection<Department> getAllDepartment() {
        return departmentStorage.getAllDepartment();
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentStorage.getDepartment(id);
    }

    @Override
    public String getDepName(Long id) {
        return departmentStorage.getDepName(id);
    }
}
