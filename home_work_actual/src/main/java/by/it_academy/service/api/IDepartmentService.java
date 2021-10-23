package by.it_academy.service.api;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;

import java.util.Collection;

public interface IDepartmentService {
    Long putDepartment(Department department, Long parentId);

    Long updateDepartment(Department department);

    Collection<Department> getAllDepartment(Long limit, Long offset);

    Department getDepartment(Long id);

    String getDepName(Department department);

    Long getDepId(Department department);

    Long getOffset(Long page, Long limit);

    Long getMaxPage(Long limit);
}
