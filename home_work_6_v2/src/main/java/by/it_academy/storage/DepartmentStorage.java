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
    public String getDepName(Department department) {
        String name;
        if (department.getDName() != null) {
            return department.getDName();
        } else if (department.getId() != null) {
            Long id = department.getId();
            try (Connection connection = dbInitializer.getCpds().getConnection()) {
                final Statement statement = connection.createStatement();
                try (ResultSet resultSet = statement.executeQuery("SELECT name FROM application.departments WHERE id=" + id)) {
                   resultSet.next();
                    name = resultSet.getString(1);
                }
            } catch (SQLException e) {
                throw new IllegalArgumentException("Ошибка работы с базой данных(DEP)", e);
            }
        } else {
            throw new IllegalArgumentException("Не задано обязательного условия для получения имени -DEP");
        }
        return name;
    }

    @Override
    public Long getDepId(Department department) {
        Long id;
        if (department.getId() != null) {
            id = department.getId();
        } else if (department.getDName() != null) {
            try (Connection connection = dbInitializer.getCpds().getConnection()) {
                String name = department.getDName();
                Statement statement = connection.createStatement();
                try (ResultSet resultSet = statement.executeQuery("SELECT id FROM application.positions WHERE name=" + name)) {
                    resultSet.next();
                    id = resultSet.getLong(1);
                }
            } catch (SQLException e) {
                throw new IllegalStateException("Ошибка получения ID", e);
            }
        } else {
            throw new IllegalArgumentException("Не задано обязательного условия для получения ID -DEP");
        }
        return id;
    }

    public static DepartmentStorage getInstance() {
        return instance;
    }
}
