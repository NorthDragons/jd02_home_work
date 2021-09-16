package by.it_academy.service;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Employee;
import by.it_academy.service.api.IEmployerService;
import by.it_academy.storage.EmployeeStorage;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;

public class EmployeeService implements IEmployerService {
    private static final EmployeeService instance = new EmployeeService();
    private static EmployeeStorage storage;
    private static HEmploeeHelper hEmploeeHelper;

    private static DepartmentService departmentService;
    private static PositionService positionService;

    public EmployeeService() {
        hEmploeeHelper = HEmploeeHelper.getInstance();
        storage = EmployeeStorage.getInstance();

        departmentService = DepartmentService.getInstance();
        positionService = PositionService.getInstance();
    }


    public static EmployeeService getInstance() {
        return instance;
    }

    @Override
    public String getPosName(Long id) {
        return positionService.getPosName(id);
    }

    @Override
    public String getDepName(Long id) {
        return departmentService.getDepName(id);
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
        return hEmploeeHelper.allMapping(resultSet);
    }

    @Override
    public Employee onceMapping(ResultSet resultSet) {
        return hEmploeeHelper.onceMapping(resultSet);
    }
}
