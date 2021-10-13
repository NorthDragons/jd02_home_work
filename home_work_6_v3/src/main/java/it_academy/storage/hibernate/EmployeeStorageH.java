package it_academy.storage.hibernate;/* created by Kaminskii Ivan
 */

import it_academy.model.Employee;
import it_academy.storage.api.IEmpStorage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

public class EmployeeStorageH implements IEmpStorage {
    private final SessionFactory sessionFactory;
    private static final EmployeeStorageH instance = new EmployeeStorageH();

    public EmployeeStorageH() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static EmployeeStorageH getInstance() {
        return instance;
    }


    @Override
    public Long putEmployer(Employee employer) {
        return null;
    }

    @Override
    public Collection<Employee> getEmployee(Long id) {
        Session sessionOne = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = sessionFactory.createEntityManager().getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        Root<Employee> itemRoot = criteriaQuery.from(Employee.class);

            criteriaQuery.where(
                            criteriaBuilder.equal(itemRoot.get("id"), id)
            );
        return sessionOne.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Collection<Employee> getAllEmployers(Long limit, Long offset) {
        return null;
    }

    @Override
    public Long getMaxPage(Long limit) {
        return null;
    }

    @Override
    public Collection<Employee> getEmpByName(String name) {
        Session sessionOne = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = HibernateUtil.getSessionFactory().createEntityManager().getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        Root<Employee> itemRoot = criteriaQuery.from(Employee.class);

        criteriaQuery.where(
                criteriaBuilder.equal(itemRoot.get("name"), name)
        );

        sessionOne.createQuery(criteriaQuery).getFetchSize();
        return sessionOne.createQuery(criteriaQuery).getResultList();
    }
}