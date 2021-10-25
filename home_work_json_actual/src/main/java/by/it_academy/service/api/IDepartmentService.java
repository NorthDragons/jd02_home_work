package by.it_academy.service.api;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;

import java.util.Collection;

public interface IDepartmentService {
    Long putDepartment(Department department, Long parentId);

    Long updateDepartment(Department department, Long parId);

    Collection<Department> getAllDepartment(Long limit, Long page);

    Department getDepartment(Long id);

    String getDepName(Department department);

    Long getMaxPage(Long limit);
}
