package it_academy.storage.api;

import it_academy.model.Employee;

import java.util.Collection;

public interface IEmpStorage {
    Long putEmployer(Employee employer);

    Employee getEmployee(Long id);

    Collection<Employee> getAllEmployers(Long limit, Long offset);

    Long getMaxPage(Long limit);
}
