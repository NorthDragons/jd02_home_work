package by.it_academy.service.api;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Employee;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;

public interface IEmployerService {


    String getPosName(Long id);

    String getDepName(Long id);

    Collection<Employee> getAllEmp();

    Employee getEmp(Long id);

    List<Employee> allMapping(ResultSet resultSet);

    Employee onceMapping(ResultSet resultSet);
}
