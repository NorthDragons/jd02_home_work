package it_academy.TestMain;/* created by Kaminskii Ivan
 */

import it_academy.model.Employee;
import it_academy.service.hibernate.EmployeeServiceH;
import it_academy.storage.hibernate.EmployeeFindBySalary;

import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeFindBySalary employeeFindBySalary = new EmployeeFindBySalary();
        final List<Employee> employee = employeeFindBySalary.findEmployee("Иван", 10.00, "more");
        System.out.println(employee.toString());
//        final EmployeeServiceH instance = EmployeeServiceH.getInstance();
//        final Collection<Employee> emp = instance.getEmp(1L);
//        instance.getEmpByName("Иван");
//        System.out.println(emp.stream());
//        final IDepService bean = context.getBean(IDepService.class);

    }
}
