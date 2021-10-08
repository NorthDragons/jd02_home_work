package it_academy.service.hibernate;/* created by Kaminskii Ivan
 */

import it_academy.model.Department;
import it_academy.model.Employee;
import it_academy.model.Position;
import it_academy.service.api.IEmpService;
import it_academy.service.sql.Offset;
import it_academy.storage.api.IEmpStorage;
import it_academy.storage.hibernate.EmployeeStorageH;
import org.hibernate.SessionFactory;

import java.util.Collection;

public class EmployeeServiceH implements IEmpService {
    private final IEmpStorage employeeStorageH;


    public EmployeeServiceH(IEmpStorage employeeStorageH) {
        this.employeeStorageH = employeeStorageH;

    }

    @Override
    public Long putEmployer(Employee employer) {
        return null;
    }

    @Override
    public Employee getEmp(Long id) {
        return null;
    }

    @Override
    public Collection<Employee> getAllEmp(Long limit, Long offset) {
        return null;
    }

    @Override
    public String getPosName(Position position) {
        return null;
    }

    @Override
    public Long getPosId(Position position) {
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
        return Offset.getOffset(page, limit);
    }

    @Override
    public Long getMaxPage(Long limit) {
        return null;
    }
}
