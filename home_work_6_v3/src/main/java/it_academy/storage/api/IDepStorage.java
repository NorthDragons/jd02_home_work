package it_academy.storage.api;

import it_academy.model.Department;

import java.util.Collection;

public interface IDepStorage {
    Long putDepartment(Department name, Long parentId);

    Collection<Department> getAllDepartment();

    Department getDepartment(Long id);

    String getDepName(Department department);

    Long getDepId(Department department);

    Long getMaxPage(Long limit);
}
