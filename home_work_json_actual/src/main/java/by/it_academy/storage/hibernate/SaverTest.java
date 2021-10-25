package by.it_academy.storage.hibernate;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Employee;
import org.hibernate.Session;

public class SaverTest {


    public Long putEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
        return employee.getId();
    }

}
