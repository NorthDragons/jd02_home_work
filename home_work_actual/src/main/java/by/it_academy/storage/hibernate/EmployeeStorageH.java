package by.it_academy.storage.hibernate;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Employee;
import by.it_academy.storage.api.IEmployerStorage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

public class EmployeeStorageH implements IEmployerStorage {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Long putEmployer(Employee employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
        return employee.getId();
    }

    @Override
    public Long updateEmployer(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
//        employee=session.
        return null;
    }

    @Override
    public Employee getEmployee(Long id) {
        Session session = sessionFactory.openSession();
        final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        final CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.where(
                criteriaBuilder.and(
//                criteriaBuilder("id",id);

                )
        );
        return null;
    }

    @Override
    public Collection<Employee> getAllEmployers(Long limit, Long offset) {
        final Session session = sessionFactory.openSession();
        final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        final CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

        criteriaQuery.select(employeeRoot).orderBy(criteriaBuilder.asc(employeeRoot.get("id")));
        final Query<Employee> query = session.createQuery(criteriaQuery);
        query.setFirstResult(Math.toIntExact(offset));
        query.setMaxResults(Math.toIntExact(limit));
        List<Employee> employees = query.list();
        session.close();
        return employees;
    }

    @Override
    public Long getMaxPage(Long limit) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(Employee.class)));
        float aFloat = ((float) session.createQuery(cq).getSingleResult() / (float) limit);
        return (Long) (long) Math.ceil(aFloat);
    }
}
