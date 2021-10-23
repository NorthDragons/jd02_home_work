package by.it_academy.service.hibernate;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.service.api.IDepartmentService;

import java.util.Collection;

public class DepartmentServiceH implements IDepartmentService {
    private static final DepartmentServiceH instance = new DepartmentServiceH();

    public static DepartmentServiceH getInstance() {
        return instance;
    }

    @Override
    public Long putDepartment(Department department, Long parentId) {
        return null;
    }

    @Override
    public Long updateDepartment(Department department) {
        return null;
    }

    @Override
    public Collection<Department> getAllDepartment(Long limit, Long offset) {
        return null;
    }

    @Override
    public Department getDepartment(Long id) {
        return null;
    }

    @Override
    public String getDepName(Department department) {
        return null;
    }

    @Override
    public Long getDepId(Department department) {
        return null;
    }

    @Override
    public Long getOffset(Long page, Long limit) {
        return null;
    }

    @Override
    public Long getMaxPage(Long limit) {
        return null;
    }
}
