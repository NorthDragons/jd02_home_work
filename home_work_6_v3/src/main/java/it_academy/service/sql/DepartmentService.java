package it_academy.service.sql;/* created by Kaminskii Ivan
 */

import it_academy.model.Department;
import it_academy.service.api.IDepService;
import it_academy.service.hibernate.DepartmentServiceH;

import java.util.Collection;

public class DepartmentService implements IDepService {
    private static final DepartmentService instance= new DepartmentService();

    public static DepartmentService getInstance() {
        return instance;
    }

    @Override
    public Long putDepartment(Department name, Long parentId) {
        return null;
    }

    @Override
    public Collection<Department> getAllDepartment() {
        return null;
    }

    @Override
    public Department getDepartment(Long id) {
        return null;
    }

    @Override
    public String getDepName(Department department) {
        return null;
    }

    @Override
    public Long getDepId(Department department) {
        return null;
    }

    @Override
    public Long getOffset(Long page, Long limit) {
        return null;
    }

    @Override
    public Long getMaxPage(Long limit) {
        return null;
    }
}
