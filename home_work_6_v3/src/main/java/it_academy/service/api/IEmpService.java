package it_academy.service.api;

import it_academy.model.Department;
import it_academy.model.Employee;
import it_academy.model.Position;

import java.util.Collection;

public interface IEmpService {

    Long putEmployer(Employee employer);

    String getPosName(Position position);

    Long getPosId(Position position);

    String getDepName(Department department);

    Long getDepId(Department department);

    Collection<Employee> getAllEmp(Long limit, Long offset);

    Collection<Employee> getEmp(Long id);

    Collection<Employee> getEmpByName(String name);

    Long getOffset(Long page, Long limit);

    Long getMaxPage(Long limit);

}
