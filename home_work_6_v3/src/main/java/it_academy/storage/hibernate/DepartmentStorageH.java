package it_academy.storage.hibernate;/* created by Kaminskii Ivan
 */

import it_academy.model.Department;
import it_academy.storage.api.IDepStorage;
import org.hibernate.SessionFactory;

import java.util.Collection;

public class DepartmentStorageH implements IDepStorage {
    private final SessionFactory sessionFactory;

    public DepartmentStorageH(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
    public Long getMaxPage(Long limit) {
        return null;
    }
}
