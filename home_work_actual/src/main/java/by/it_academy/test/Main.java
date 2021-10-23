package by.it_academy.test;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Employee;
import by.it_academy.storage.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

public class Main {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public static void main(String[] args) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(Employee.class)));
        final Long count = session.createQuery(cq).getSingleResult();

        System.out.println(count);


//        EmployeeFindBySalary employeeFindBySalary = new EmployeeFindBySalary();
//        final List<Employee> more = employeeFindBySalary.findEmployee(88.88, "more");
//        for (Employee employee : more) {
//
//            System.out.println(employee.toString());
//        SaverTest saverTest = new SaverTest();
//        Position position = new Position();
//        position.setId(1L);
//
//        Department department = new Department();
//        department.setId(1L);
//
//        Employee employee = new Employee();
//        employee.setName("testName");
//        employee.setSalary(19999.99);
//        employee.setDepartment(department);
//        employee.setPosition(position);
//
//        final Long id = saverTest.putEmployee(employee);
//        System.out.println(id);
    }
}

