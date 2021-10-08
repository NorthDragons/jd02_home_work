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

    Employee getEmp(Long id);

    Long getOffset(Long page, Long limit);

    Long getMaxPage(Long limit);
}
