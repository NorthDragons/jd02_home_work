package by.it_academy.service;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.model.Employee;
import by.it_academy.model.Position;
import by.it_academy.service.api.IEmployerService;
import by.it_academy.storage.EmployeeStorage;

import java.util.Collection;

public class EmployeeService implements IEmployerService {
    private final static EmployeeService instance = new EmployeeService();


    private final EmployeeStorage storage;


    private final DepartmentService departmentService;
    private final PositionService positionService;

    public EmployeeService() {
        departmentService = DepartmentService.getInstance();
        storage = EmployeeStorage.getInstance();
        positionService = PositionService.getInstance();
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
    public Collection<Employee> getAllEmp() {
        return storage.getAllEmployers();
    }

    @Override
    public Employee getEmp(Long id) {
        return storage.getEmployee(id);
    }

    public static EmployeeService getInstance(){
        return instance;
    }

}
