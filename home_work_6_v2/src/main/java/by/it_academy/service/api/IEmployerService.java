package by.it_academy.service.api;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.model.Employee;
import by.it_academy.model.Position;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;

public interface IEmployerService {


    String getPosName(Position position);
    Long getPosId(Position position);

    String getDepName(Department department);
    Long getDepId(Department department);

    Collection<Employee> getAllEmp();

    Employee getEmp(Long id);

    List<Employee> allMapping(ResultSet resultSet);

    Employee onceMapping(ResultSet resultSet);
}
