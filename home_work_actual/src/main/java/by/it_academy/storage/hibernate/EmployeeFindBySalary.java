package by.it_academy.storage.hibernate;/* created by Kaminskii Ivan
 */

import by.it_academy.model.hibernate.EmployeeQuery;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeFindBySalary {


    public List<EmployeeQuery> findEmployee(String name, Double salary, String mode) {
        Session sessionOne = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder criteriaBuilder = HibernateUtil.getSessionFactory().createEntityManager().getCriteriaBuilder();
        CriteriaQuery<EmployeeQuery> criteriaQuery = criteriaBuilder.createQuery(EmployeeQuery.class);

        Root<EmployeeQuery> itemRoot = criteriaQuery.from(EmployeeQuery.class);

    if(mode.equals("more")){
        criteriaQuery.where(
                criteriaBuilder.and(
                        criteriaBuilder.equal(itemRoot.get("name"), name),
                        criteriaBuilder.greaterThanOrEqualTo(itemRoot.get("salary"), salary)
                )
        );
    }else if(mode.equals("less")){
        criteriaQuery.where(
                criteriaBuilder.and(
                        criteriaBuilder.equal(itemRoot.get("name"), name),
                        criteriaBuilder.lessThanOrEqualTo(itemRoot.get("salary"), salary)
                )
        );
    }
        return sessionOne.createQuery(criteriaQuery).getResultList();
    }

}
