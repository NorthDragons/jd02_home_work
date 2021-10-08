package homeWork.main.test1;/* created by Kaminskii Ivan
 */

import homeWork.main.one_to_one_main.HibernateUtil;
import homeWork.model.oneToOne.Employee;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MainManyToMany {
    public static void main(String[] args) {
        Session sessionOne = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder criteriaBuilder = HibernateUtil.getSessionFactory().createEntityManager().getCriteriaBuilder();

        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        Root<Employee> itemRoot = criteriaQuery.from(Employee.class);

        criteriaQuery.where(
                criteriaBuilder.and(
                        criteriaBuilder.equal(itemRoot.get("name"), "9999")
                )
        );

        List<Employee> resultList = sessionOne.createQuery(criteriaQuery).getResultList();

        for (Employee employee : resultList) {
            System.out.println(employee);
        }


        HibernateUtil.shutdown();
    }
}
