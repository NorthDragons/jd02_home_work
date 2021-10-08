package by.it_academy.service.api;

import by.it_academy.model.sql.Department;
import by.it_academy.model.sql.Employee;
import by.it_academy.model.sql.Position;

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
