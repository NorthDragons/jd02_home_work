package by.it_academy.storage;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.storage.api.IDepartmentStorage;

import java.sql.*;

public class DepartmentStorage implements IDepartmentStorage {
    DBInitializer dbInitializer;

    public DepartmentStorage() {
        this.dbInitializer = DBInitializer.getInstance();
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
    public Department getDepartment(Long id) {
        Department department = new Department();
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("SELECT departments.id," +
                    " departments.name, departments.parent_dep FROM application.departments WHERE id=" + id)) {
                department.setId(resultSet.getLong(1));
                department.setDName(resultSet.getString(2));
                if ((resultSet.getLong(1) == resultSet.getLong(3))) {
                    department.setParentDep(department);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
