package by.it_academy.service;/* created by Kaminskii Ivan
 */

import by.it_academy.model.hibernate.EmployeeQuery;
import by.it_academy.model.sql.Department;
import by.it_academy.model.sql.Employee;
import by.it_academy.model.sql.Position;
import by.it_academy.service.api.IEmployerService;
import by.it_academy.storage.hibernate.EmployeeFindBySalary;
import by.it_academy.storage.sql.EmployeeStorage;

import java.util.Collection;
import java.util.List;

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
    public Long putEmployer(Employee employer) {
        return storage.putEmployer(employer);
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
    public Collection<Employee> getAllEmp(Long limit, Long offset) {
        return storage.getAllEmployers(limit, offset);
    }

    @Override
    public Employee getEmp(Long id) {
        return storage.getEmployee(id);
    }

    @Override
    public Long getOffset(Long page, Long limit) {
        if(page==0){
            return page;
        }
        return (page - 1L) * limit;
    }

    @Override
    public Long getMaxPage(Long limit) {
        return storage.getMaxPage(limit);
    }

    public static EmployeeService getInstance() {
        return instance;
    }

    public List<EmployeeQuery> findEmployee(String name, Double salary, String mode){
        EmployeeFindBySalary finder=new EmployeeFindBySalary();
        return finder.findEmployee(name, salary, mode);
    }

}
