package by.it_academy.service;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.service.api.IDepartmentService;
import by.it_academy.storage.DepartmentStorage;

import java.util.Collection;

public class DepartmentService implements IDepartmentService {
    private static final DepartmentService instance = new DepartmentService();
    private final DepartmentStorage departmentStorage;
    private final HDepartmentHepler hDepartmentHepler;

    private final EmployeeService employeeService;
    private final PositionService positionService;

    public DepartmentService() {
        hDepartmentHepler = HDepartmentHepler.getInstance();
        departmentStorage = DepartmentStorage.getInstance();
        employeeService = EmployeeService.getInstance();
        positionService = PositionService.getInstance();
    }

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
    public String getDepName(Department department) {
        return departmentStorage.getDepName(department);
    }

    @Override
    public Long getDepId(Department department) {
        return departmentStorage.getDepId (department);
    }
}
