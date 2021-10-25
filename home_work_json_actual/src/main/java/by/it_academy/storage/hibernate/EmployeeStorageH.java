package by.it_academy.storage.hibernate;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Employee;
import by.it_academy.storage.api.IEmployerStorage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class EmployeeStorageH implements IEmployerStorage {
    private static final EmployeeStorageH instance = new EmployeeStorageH();

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Long putEmployer(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
        return employee.getId();
    }

    @Override
    public Long updateEmployer(Employee employee) {
        try (Session session = sessionFactory.openSession();) {
            final Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        } catch (IllegalStateException | HibernateException e) {
            e.printStackTrace();
        }

        return Objects.requireNonNull(employee).getId();
    }

    @Override
    public Employee getEmployee(Long id) {
        Employee employee;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            transaction.commit();
        }
        return employee;
    }

    @Override
    public Collection<Employee> getAllEmployers(Long limit, Long page) {
        long offset = 0L;
        if (page > 0) {
            offset = (page - 1L) * limit;
        }
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
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(Employee.class)));
        float aFloat = ((float) session.createQuery(criteriaQuery).getSingleResult() / (float) limit);
        return (long) Math.ceil(aFloat);
    }

    public static EmployeeStorageH getInstance() {
        return instance;
    }
}
