package by.it_academy.test;/* created by Kaminskii Ivan
 */

import by.it_academy.model.hibernate.EmployeeQuery;
import by.it_academy.model.sql.Employee;
import by.it_academy.model.sql.Position;
import by.it_academy.service.api.IEmployerService;
import by.it_academy.service.sql.EmployeeService;
import by.it_academy.storage.hibernate.EmployeeFindBySalary;
import by.it_academy.storage.sql.CreatDB;
import by.it_academy.storage.sql.DBInitializer;
import by.it_academy.storage.api.DBCreator;
import by.it_academy.storage.sql.PositionStorage;

import java.util.Collection;
import java.util.List;

public class Main {
    private static final DBInitializer dbInitializer = DBInitializer.getInstance();

    public static void main(String[] args) {
        final EmployeeService service = EmployeeService.getInstance();
        final Employee emp = service.getEmp(20L);
        System.out.println(emp.toString());
        emp.setName("test");
        final Long e = service.updateEmployer(emp);

        System.out.println(service.getEmp(e).toString());
    }
}
