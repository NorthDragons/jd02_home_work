package it_academy.service.sql;/* created by Kaminskii Ivan
 */

import it_academy.model.Department;
import it_academy.model.Employee;
import it_academy.model.Position;
import it_academy.service.api.IEmpService;

import java.util.Collection;

public class EmployeeService implements IEmpService {
    private static final EmployeeService instance = new EmployeeService();

    public static EmployeeService getInstance() {
        return instance;
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
