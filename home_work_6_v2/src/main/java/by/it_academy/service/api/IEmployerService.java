package by.it_academy.service.api;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Employee;

import java.util.Collection;

public interface IEmployerService {


    String getPosName(Long id);

    String getDepName(Long id);

    Collection<Employee> getAllEmp();
    Employee getEmp(Long id);
}
