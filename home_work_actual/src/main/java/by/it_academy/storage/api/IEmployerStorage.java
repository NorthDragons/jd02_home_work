package by.it_academy.storage.api;

import by.it_academy.model.sql.Employee;

import java.util.Collection;

public interface IEmployerStorage {
    Long putEmployer(Employee employer);

    Long updateEmployer(Employee employer);

    Employee getEmployee(Long id);

    Collection<Employee> getAllEmployers(Long limit, Long offset);

    Long getMaxPage(Long limit);


}
