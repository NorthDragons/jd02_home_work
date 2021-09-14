package by.it_academy.storage.api;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;

public interface IDepartmentStorage {
    void putDepartment(Department department, Long parentId);

    Department getDepartment(Long id);
}
