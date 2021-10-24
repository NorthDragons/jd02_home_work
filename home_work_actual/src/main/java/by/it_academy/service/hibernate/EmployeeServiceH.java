package by.it_academy.service.hibernate;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.model.Employee;
import by.it_academy.model.Position;
import by.it_academy.service.api.IEmployerService;
import by.it_academy.service.sql.PositionService;
import by.it_academy.storage.hibernate.EmployeeStorageH;

import java.util.Collection;

public class EmployeeServiceH implements IEmployerService {
    private static final EmployeeServiceH instance = new EmployeeServiceH();
    private final DepartmentServiceH departmentServiceH;
    private final PositionServiceH positionServiceH;
    private final EmployeeStorageH employeeStorageH;

    public EmployeeServiceH() {
        this.employeeStorageH = EmployeeStorageH.getInstance();
        this.departmentServiceH = DepartmentServiceH.getInstance();
        this.positionServiceH = PositionServiceH.getInstance();
    }

    public static EmployeeServiceH getInstance() {
        return instance;
    }

    @Override
    public Long putEmployer(Employee employee) {
        return employeeStorageH.putEmployer(employee);
    }

    @Override
    public Long updateEmployer(Employee employee) {
        return employeeStorageH.updateEmployer(employee);
    }

    @Override
    public String getPosName(Position position) {
        if (position.getName() != null && !(position.getName().isBlank())) {
            return position.getName();
        } else {
            return positionServiceH.getPosName(position);
        }
    }

    @Override
    public String getDepName(Department department) {
        if(department.getName()!=null&&!(department.getName().isBlank())){
            return department.getName();
        }
        return departmentServiceH.getDepName(department);
    }

    @Override
    public Collection<Employee> getAllEmp(Long limit, Long offset) {
        return employeeStorageH.getAllEmployers(limit, offset);
    }

    @Override
    public Employee getEmp(Long id) {
        return employeeStorageH.getEmployee(id);
    }

    @Override
    public Long getOffset(Long page, Long limit) {
        if (page == 0) {
            return page;
        }
        return (page - 1L) * limit;
    }

    @Override
    public Long getMaxPage(Long limit) {
        return employeeStorageH.getMaxPage(limit);
    }
}
