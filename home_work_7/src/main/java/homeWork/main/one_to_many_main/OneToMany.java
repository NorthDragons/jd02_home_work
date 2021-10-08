package homeWork.main.one_to_many_main;/* created by Kaminskii Ivan
 */

import homeWork.model.oneToMany.Department;
import homeWork.model.oneToMany.Employee;
import org.hibernate.Session;

import java.util.LinkedList;
import java.util.List;

public class OneToMany {
    public static void main(String[] args) {
        Session sessionOne = HibernateUtil.getSessionFactory().openSession();
        sessionOne.beginTransaction();

        Employee employee = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();
        employee.setName("8888");
        employee2.setName("28888");
        employee3.setName("18888");
        sessionOne.save(employee);

        List<Employee> employees = new LinkedList<>();
        employees.add(employee);
        Department department = new Department();

        department.setEmployees(employees);
        department.setName("Колхоз 8888");

        sessionOne.save(department);

//        Employee employee = sessionOne.get(Employee.class, 4L);


        sessionOne.getTransaction().commit();


//        HibernateUtil.shutdown();
    }
}
