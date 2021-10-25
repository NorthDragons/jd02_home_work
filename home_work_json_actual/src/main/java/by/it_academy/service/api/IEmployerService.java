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

    String getDepName(Department department);

    Collection<Employee> getAllEmp(Long limit, Long page);

    Employee getEmp(Long id);

    Long getMaxPage(Long limit);

}
