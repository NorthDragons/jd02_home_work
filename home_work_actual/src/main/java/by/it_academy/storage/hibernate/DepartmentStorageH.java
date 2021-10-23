package by.it_academy.storage.hibernate;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.storage.api.IDepartmentStorage;

import java.util.Collection;

public class DepartmentStorageH implements IDepartmentStorage {
    @Override
    public Long putDepartment(Department name, Long parentId) {
        return null;
    }

    @Override
    public Long updateDepartment(Department name) {
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
    public Long getMaxPage(Long limit) {
        return null;
    }
}
