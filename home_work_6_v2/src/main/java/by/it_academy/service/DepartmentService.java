package by.it_academy.service;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.service.api.IDepartmentService;
import by.it_academy.storage.DBInitializer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentService implements IDepartmentService {
    private static DBInitializer dbInitializer;

    public DepartmentService() {
        dbInitializer = DBInitializer.getInstance();
    }

    private static final DepartmentService instance = new DepartmentService();

    public static DepartmentService getInstance() {
        return instance;
    }

    @Override
    public void putDepartment(Department department, Long parentId) {

    }

    @Override
    public Department getDepartment(Long id) {
        Department department = new Department();
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            final Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM application.departments WHERE id=" + id)) {
                department.setId(resultSet.getLong(1));
                department.setDName(resultSet.getString(2));
                if (resultSet.getLong(1) != resultSet.getLong(3)) {
                    department.setParentDep(this.getDepartment(resultSet.getLong(3)));
                } else {
                    Department parentDep = new Department();
                    parentDep.setDName("Не имеет родительского отдела");
                    department.setParentDep(parentDep);
                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка работы с базой данных(DEP)", e);
        }
        return department;
    }

    @Override
    public String getDepName(Long id) {
        String name;
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            final Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("SELECT name FROM application.departments WHERE id=" + id)) {
                name = resultSet.getString(1);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка работы с базой данных(DEP", e);
        }
        return name;
    }
}
