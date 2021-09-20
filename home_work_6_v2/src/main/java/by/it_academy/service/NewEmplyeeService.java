package by.it_academy.service;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.model.Employee;
import by.it_academy.model.Position;
import by.it_academy.service.api.INewEmployyService;
import by.it_academy.storage.EmployeeStorage;

import java.util.Collection;

public class NewEmplyeeService implements INewEmployyService {
    private static final NewEmplyeeService instance = new NewEmplyeeService();

    private final EmployeeStorage employeeStorage;
    private final PositionService positionService;
    private final DepartmentService departmentService;

    public NewEmplyeeService() {
        departmentService = DepartmentService.getInstance();
        positionService = PositionService.getInstance();
        employeeStorage = EmployeeStorage.getInstance();
    }

    @Override
    public String getPosName(Position position) {
        return positionService.getPosName(position);
    }

    @Override
    public Long getPosId(Position position) {
        return positionService.getPosId(position);
    }

    @Override
    public String getDepName(Department department) {
        return departmentService.getDepName(department);
    }

    @Override
    public Long getDepId(Department department) {
        return departmentService.getDepId(department);
    }

    @Override
    public void putEmployee(Employee employee) {
        employeeStorage.putEmployer(employee);
    }

    @Override
    public Collection<Employee> getAllEmp() {
        return employeeStorage.getAllEmployers();
    }

    @Override
    public Employee getEmp(Long id) {
        return employeeStorage.getEmployee(id);
    }

    public static NewEmplyeeService getInstance(){
        return instance;
    }
}
