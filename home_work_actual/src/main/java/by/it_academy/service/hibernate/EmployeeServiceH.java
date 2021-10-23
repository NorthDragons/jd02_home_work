package by.it_academy.service.hibernate;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.model.Employee;
import by.it_academy.model.Position;
import by.it_academy.service.api.IEmployerService;

import java.util.Collection;

public class EmployeeServiceH implements IEmployerService {
    private static final EmployeeServiceH instance= new EmployeeServiceH();

    public static EmployeeServiceH getInstance() {
        return instance;
    }

    @Override
    public Long putEmployer(Employee employer) {
        return null;
    }

    @Override
    public Long updateEmployer(Employee employer) {
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
    public Collection<Employee> getAllEmp(Long limit, Long offset) {
        return null;
    }

    @Override
    public Employee getEmp(Long id) {
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
