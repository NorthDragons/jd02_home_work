package homeWork.main.one_to_one_main;/* created by Kaminskii Ivan
 */

import homeWork.model.oneToOne.Department;
import homeWork.model.oneToOne.Employee;
import org.hibernate.Session;

public class OneToOne {
    public static void main(String[] args) {
        Session sessionOne = HibernateUtil.getSessionFactory().openSession();
        sessionOne.beginTransaction();

        Department department = new Department();
        department.setName("Колхоз 8888");

        sessionOne.save(department);

//        Employee employee = sessionOne.get(Employee.class, 4L);
        Employee employee = new Employee();

        employee.setName("8888");
        employee.setDepartment(department);

        sessionOne.save(employee);


        sessionOne.getTransaction().commit();


//        HibernateUtil.shutdown();
    }
}
