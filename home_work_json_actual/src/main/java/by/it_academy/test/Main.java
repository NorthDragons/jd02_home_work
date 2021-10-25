package by.it_academy.test;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Employee;
import by.it_academy.model.Position;
import by.it_academy.storage.hibernate.HibernateUtil;
import by.it_academy.storage.hibernate.PositionStorageH;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final PositionStorageH positionStorageH = PositionStorageH.getInstance();

    public static void main(String[] args) {
        Position position= new Position();
        position.setName("testAdd");
        final Long aLong = positionStorageH.putPosition(position);
        System.out.println(aLong);


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

    private static void update(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.clear();
        final Transaction transaction = session.beginTransaction();
        final Employee updateEmp = session.get(Employee.class, employee.getId());
        if (updateEmp == null) {
            throw new IllegalStateException("Не найдено пользователя с ID:" + employee.getId());
        } else {
            if (employee.getName() != null && !(employee.getName().isBlank())) {
                updateEmp.setName(employee.getName());
            } else if (employee.getDepartment() != null) {
                updateEmp.setDepartment(employee.getDepartment());
            } else if (employee.getPosition() != null) {
                updateEmp.setPosition(employee.getPosition());
            } else if (employee.getSalary() != null) {
                updateEmp.setSalary(employee.getSalary());
            }
            session.update(updateEmp);
            transaction.commit();
            session.close();
        }
    }
}

