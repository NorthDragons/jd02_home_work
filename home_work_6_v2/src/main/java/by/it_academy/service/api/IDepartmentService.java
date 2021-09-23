package by.it_academy.service.api;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;

import java.util.Collection;

public interface IDepartmentService {
    Long putDepartment(Department name, Long parentId);

    Collection<Department> getAllDepartment();

    Department getDepartment(Long id);

    String getDepName(Department department);

    Long getDepId(Department department);

    Long getOffset(Long page, Long limit);

    Long getMaxPage(Long limit);
}
