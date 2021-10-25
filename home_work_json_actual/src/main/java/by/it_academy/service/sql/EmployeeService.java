package by.it_academy.service.sql;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.model.Employee;
import by.it_academy.model.Position;
import by.it_academy.service.api.IDepartmentService;
import by.it_academy.service.api.IEmployerService;
import by.it_academy.storage.sql.EmployeeStorage;

import java.util.Collection;

public class EmployeeService implements IEmployerService {
    private final static EmployeeService instance = new EmployeeService();


    private final EmployeeStorage employeeStorage;


    private final IDepartmentService departmentService;
    private final PositionService positionService;

    public EmployeeService() {
        departmentService = DepartmentService.getInstance();
        employeeStorage = EmployeeStorage.getInstance();
        positionService = PositionService.getInstance();
    }


    @Override
    public Long putEmployer(Employee employer) {
        return employeeStorage.putEmployer(employer);
    }

    @Override
    public Long updateEmployer(Employee employer) {
        return employeeStorage.updateEmployer(employer);
    }

    @Override
    public String getPosName(Position position) {
        return positionService.getPosName(position);
    }



    @Override
    public String getDepName(Department department) {
        return departmentService.getDepName(department);
    }

    @Override
    public Collection<Employee> getAllEmp(Long limit, Long page) {
        return employeeStorage.getAllEmployers(limit, page);
    }

    @Override
    public Employee getEmp(Long id) {
        return employeeStorage.getEmployee(id);
    }

    @Override
    public Long getMaxPage(Long limit) {
        return employeeStorage.getMaxPage(limit);
    }


    public static EmployeeService getInstance() {
        return instance;
    }

}
