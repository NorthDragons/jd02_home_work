package by.it_academy.storage.api;

import by.it_academy.model.Employee;

import java.util.Collection;

public interface IEmployerStorage {
    Long putEmployer(Employee employee);

    Long updateEmployer(Employee employee);

    Employee getEmployee(Long id);

    Collection<Employee> getAllEmployers(Long limit, Long offset);

    Long getMaxPage(Long limit);


}
