package by.it_academy.storage.hibernate;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.storage.api.IDepartmentStorage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DepartmentStorageH implements IDepartmentStorage {
    private static final DepartmentStorageH instance = new DepartmentStorageH();
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Long putDepartment(Department department, Long parentId) {
        Department parentDep;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            parentDep = session.get(Department.class, parentId);
            if (parentDep != null) {
                department.setParent_dep(parentDep);
            }
            session.save(department);
            transaction.commit();
        }
        return department.getId();
    }

    @Override
    public Long updateDepartment(Department department, Long parId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            if (department == null) {
                throw new IllegalStateException("Не найден отдел с таким ID");
            } else {
                if (parId != 0L) {
                    Department parentDep = session.get(Department.class, parId);
                    department.setParent_dep(parentDep);
                }
                session.update(department);

                transaction.commit();
            }
        }
        return department.getId();
    }

    @Override
    public Collection<Department> getAllDepartment(Long limit, Long offset) {
        List<Department> departments;
        try (Session session = sessionFactory.openSession()) {
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
            final Root<Department> itemRoot = criteriaQuery.from(Department.class);
            final Query<Department> query = session.createQuery(criteriaQuery);
            query.setFirstResult(Math.toIntExact(offset));
            query.setMaxResults(Math.toIntExact(limit));
            departments = query.list();
        }
        return departments;
    }

    @Override
    public Department getDepartment(Long id) {
        Department department;
        try (Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            department = session.get(Department.class, id);
            transaction.commit();
            if (department == null) {
                throw new IllegalStateException("Отдел с ID: " + id + "не найден");
            }
        }
        return department;
    }

    @Override
    public String getDepName(Department department) {
        if (department.getName() == null) {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                final Department department1 = session.get(Department.class, department.getId());
                return department1.getName();
            }
        } else {
            return department.getName();
        }
    }

    @Override
    public Long getMaxPage(Long limit) {
        return null;
    }

    public static DepartmentStorageH getInstance() {
        return instance;
    }
}
