package by.it_academy.storage;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.storage.api.IDepartmentStorage;

import java.sql.*;
import java.util.Collection;

public class DepartmentStorage implements IDepartmentStorage {
    private static DBInitializer dbInitializer;
    private static final DepartmentStorage instance = new DepartmentStorage();

    public DepartmentStorage() {
        dbInitializer = DBInitializer.getInstance();
    }

    @Override
    public void putDepartment(Department department, Long parentId) {
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO application.departments(\n" +
                    "name, parent_dep)\n" +
                    "VALUES(?,?);", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, department.getDName());
                preparedStatement.setLong(2, parentId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Collection<Department> getAllDepartment() {
        return null;
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
    public static DepartmentStorage getInstance(){
        return instance;
    }
}
