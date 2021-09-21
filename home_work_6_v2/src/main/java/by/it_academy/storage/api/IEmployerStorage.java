package by.it_academy.storage.api;

import by.it_academy.model.Employee;

import java.util.Collection;

public interface IEmployerStorage {
    void putEmployer(Employee employer);

    Employee getEmployee(Long id);

    Collection<Employee> getAllEmployers(Long limit, Long offset);

}
