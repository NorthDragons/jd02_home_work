package by.it_academy.service;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.model.Employee;
import by.it_academy.model.Position;
import by.it_academy.service.api.IEmployerService;
import by.it_academy.storage.EmployeeStorage;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;

public class EmployeeService implements IEmployerService {
    private static EmployeeStorage storage;
    private static HEmployeeHelper hEmployeeHelper;

    private static DepartmentService departmentService;
    private static PositionService positionService;
    private static final EmployeeService instance = new EmployeeService();

    public EmployeeService() {
        hEmployeeHelper = HEmployeeHelper.getInstance();
        storage = EmployeeStorage.getInstance();
        departmentService = DepartmentService.getInstance();
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

    @Override
    public List<Employee> allMapping(ResultSet resultSet) {
        return hEmployeeHelper.allGetMapping(resultSet);
    }

    @Override
    public Employee onceMapping(ResultSet resultSet) {
        return hEmployeeHelper.onceGetMapping(resultSet);
    }


    public static EmployeeService getInstance() {
        return instance;
    }
}
