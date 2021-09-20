package by.it_academy.service.api;

import by.it_academy.model.Department;
import by.it_academy.model.Employee;
import by.it_academy.model.Position;

import java.util.Collection;

public interface INewEmployyService {

    String getPosName(Position position);
    Long getPosId(Position position);

    String getDepName(Department department);
    Long getDepId(Department department);


    void putEmployee(Employee employee);

    Collection<Employee> getAllEmp();

    Employee getEmp(Long id);
}
