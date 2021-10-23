package by.it_academy.service.api;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.model.Employee;
import by.it_academy.model.Position;

import java.util.Collection;

public interface IEmployerService {

    Long putEmployer(Employee employer);

    Long updateEmployer(Employee employer);

    String getPosName(Position position);

    Long getPosId(Position position);

    String getDepName(Department department);

    Long getDepId(Department department);

    Collection<Employee> getAllEmp(Long limit, Long offset);

    Employee getEmp(Long id);

    Long getOffset(Long page, Long limit);

    Long getMaxPage(Long limit);

}
