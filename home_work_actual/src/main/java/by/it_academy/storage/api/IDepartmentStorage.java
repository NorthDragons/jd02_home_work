package by.it_academy.storage.api;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;

import java.util.Collection;

public interface IDepartmentStorage {
    Long putDepartment(Department name, Long parentId);

    Long updateDepartment(Department name);

    Collection<Department> getAllDepartment(Long limit, Long offset);

    Department getDepartment(Long id);

    String getDepName(Department department);

    Long getDepId(Department department);

    Long getMaxPage(Long limit);
}
