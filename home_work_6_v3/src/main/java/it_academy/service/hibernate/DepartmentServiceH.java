package it_academy.service.hibernate;/* created by Kaminskii Ivan
 */

import it_academy.model.Department;
import it_academy.service.api.IDepService;
import it_academy.storage.api.IDepStorage;

import java.util.Collection;

public class DepartmentServiceH implements IDepService {
    private static final DepartmentServiceH instance= new DepartmentServiceH();
    private final IDepStorage departmentStorageH;

    public DepartmentServiceH() {
        this.departmentStorageH = null;
    }

    public static DepartmentServiceH getInstance() {
        return instance;
    }

    @Override
    public Long putDepartment(Department name, Long parentId) {
        return null;
    }

    @Override
    public Collection<Department> getAllDepartment() {
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
