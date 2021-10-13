package by.it_academy.home_work.storage.api;

import by.it_academy.home_work.model.Employee;

import java.util.Collection;

public interface IEmployerStorage {
    Long putEmployer(Employee employer);

    Employee getEmployee(Long id);

    Collection<Employee> getAllEmployers(Long limit, Long offset);

    Long getMaxPage(Long limit);


}
