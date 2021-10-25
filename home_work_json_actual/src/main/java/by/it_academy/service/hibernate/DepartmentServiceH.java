package by.it_academy.service.hibernate;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.service.api.IDepartmentService;
import by.it_academy.storage.hibernate.DepartmentStorageH;

import java.util.Collection;

public class DepartmentServiceH implements IDepartmentService {
    private static final DepartmentServiceH instance = new DepartmentServiceH();
    private final DepartmentStorageH departmentStorageH;

    public DepartmentServiceH() {
        this.departmentStorageH = DepartmentStorageH.getInstance();
    }

    public static DepartmentServiceH getInstance() {
        return instance;
    }

    @Override
    public Long putDepartment(Department department, Long parentId) {
        return departmentStorageH.putDepartment(department, parentId);
    }

    @Override
    public Long updateDepartment(Department department, Long parId) {
        return departmentStorageH.updateDepartment(department, parId);
    }

    @Override
    public Collection<Department> getAllDepartment(Long limit, Long page) {
        return departmentStorageH.getAllDepartment(limit, page);
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentStorageH.getDepartment(id);
    }

    @Override
    public String getDepName(Department department) {
        return departmentStorageH.getDepName(department);
    }

    @Override
    public Long getMaxPage(Long limit) {
        return departmentStorageH.getMaxPage(limit);
    }
}
