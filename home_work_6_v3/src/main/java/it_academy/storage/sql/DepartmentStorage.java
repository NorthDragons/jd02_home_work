package it_academy.storage.sql;/* created by Kaminskii Ivan
 */

import it_academy.model.Department;
import it_academy.storage.api.IDepStorage;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DepartmentStorage implements IDepStorage {
    private static DBInitializer dbInitializer;
    private static final DepartmentStorage instance = new DepartmentStorage();

    public DepartmentStorage() {
        dbInitializer = DBInitializer.getInstance();
    }

    @Override
    public Long putDepartment(Department department, Long parentId) {
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO application.departments(\n" +
                    "name, parent_dep)\n" +
                    "VALUES(?,?);", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, department.getName());
                preparedStatement.setLong(2, parentId);
                preparedStatement.executeUpdate();

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    generatedKeys.next();
                    department.setId(generatedKeys.getLong(1));
                    return generatedKeys.getLong(1);
                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка добавления отдела в БД", e);
        }

    }

    @Override
    public Collection<Department> getAllDepartment() {
        List<Department> departments = new LinkedList<>();
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM application.departments")) {
                while (resultSet.next()) {
                    Department department = new Department();
                    department.setId(resultSet.getLong(1));
                    department.setName(resultSet.getString(2));
                    if (resultSet.getLong(1) != resultSet.getLong(3)) {
                        department.setParentDep(this.getDepartment(resultSet.getLong(3)));
                    } else {
                        Department parentDep = new Department();
                        parentDep.setName("Не имеет родительского отдела");
                        department.setParentDep(parentDep);
                    }
                    departments.add(department);
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка работы с Базой Данных -POS", e);
        }
        return departments;

    }

    @Override
    public Department getDepartment(Long id) {
        Department department = new Department();
        try (Connection connection = dbInitializer.getCpds().getConnection()) {
            final Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery("SELECT id, name, parent_dep FROM application.departments WHERE id=" + id)) {
                while (resultSet.next()) {
                    department.setId(resultSet.getLong(1));
                    department.setName(resultSet.getString(2));
                    if (resultSet.getLong(1) != resultSet.getLong(3)) {
                        department.setParentDep(this.getDepartment(resultSet.getLong(3)));
                    } else {
                        Department parentDep = new Department();
                        parentDep.setName("Не имеет родительского отдела");
                        department.setParentDep(parentDep);
                    }
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
        if (department.getName() != null) {
            return department.getName();
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
        } else if (department.getName() != null) {
            try (Connection connection = dbInitializer.getCpds().getConnection()) {
                String name = department.getName();
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


    @Override
    public Long getMaxPage(Long limit) {
        long maxPage = 0L;
        try (Connection connection = dbInitializer.getCpds().getConnection(); Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT COUNT(id)\n" +
                    "FROM application.departments")) {
                while (resultSet.next()) {
                    long allLine = resultSet.getLong(1);

                    float aFloat = ((float) allLine / (float) limit);
                    maxPage = (long) Math.ceil(aFloat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxPage;
    }

    public static DepartmentStorage getInstance() {
        return instance;
    }
}
