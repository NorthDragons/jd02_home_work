package it_academy.storage.hibernate;/* created by Kaminskii Ivan
 */

import it_academy.model.Employee;
import it_academy.storage.api.IEmpStorage;
import org.hibernate.SessionFactory;

import java.util.Collection;

public class EmployeeStorageH implements IEmpStorage {
    private final SessionFactory sessionFactory;

    public EmployeeStorageH(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long putEmployer(Employee employer) {
        return null;
    }

    @Override
    public Employee getEmployee(Long id) {
        return null;
    }

    @Override
    public Collection<Employee> getAllEmployers(Long limit, Long offset) {
        return null;
    }

    @Override
    public Long getMaxPage(Long limit) {
        return null;
    }
}