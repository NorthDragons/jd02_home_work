package by.it_academy.storage.api;/* created by Kaminskii Ivan
 */

import by.it_academy.model.sql.Department;

import java.util.Collection;

public interface IDepartmentStorage {
    Long putDepartment(Department name, Long parentId);

    Collection<Department> getAllDepartment();

    Department getDepartment(Long id);

    String getDepName(Department department);

    Long getDepId(Department department);

    Long getMaxPage(Long limit);
}
