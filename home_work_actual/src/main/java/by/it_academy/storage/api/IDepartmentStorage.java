package by.it_academy.storage.api;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;

import java.util.Collection;
import java.util.List;

public interface IDepartmentStorage {
    Long putDepartment(Department name, Long parentId);

    Long updateDepartment(Department name, Long parId);

    Collection<Department> getAllDepartment(Long limit, Long offset);

    Department getDepartment(Long id);

    String getDepName(Department department);

    Long getMaxPage(Long limit);
}
