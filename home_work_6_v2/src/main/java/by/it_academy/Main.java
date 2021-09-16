package by.it_academy;/* created by Kaminskii Ivan
 */


import by.it_academy.model.Employee;
import by.it_academy.service.EmployeeService;

import java.util.Collection;

public class Main {
    private static EmployeeService service;

    public Main() {
        service = EmployeeService.getInstance();
    }

    public static void main(String[] args) {

        Collection<Employee> employees = service.getAllEmp();
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }
}
