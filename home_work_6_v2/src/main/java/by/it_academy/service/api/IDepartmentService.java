package by.it_academy.service.api;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;

public interface IDepartmentService {
    void putDepartment(Department department, Long parentId);

    Department getDepartment(Long id);

    String getDepName(Long id);
}
