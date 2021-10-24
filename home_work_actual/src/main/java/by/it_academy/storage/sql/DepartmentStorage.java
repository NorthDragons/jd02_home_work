package by.it_academy.storage.sql;/* created by Kaminskii Ivan
 */

import by.it_academy.model.Department;
import by.it_academy.storage.api.IDepartmentStorage;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DepartmentStorage implements IDepartmentStorage {
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
                if (parentId != 0L) {
                    preparedStatement.setLong(2, parentId);
                } else {
                    preparedStatement.setLong(2, 1L);
                }
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
    public Long updateDepartment(Department name, Long parId) {
        return null;
    }

    @Override
    public Collection<Department> getAllDepartment(Long limit, Long offset) {
        List<Department> departments = new LinkedList<>();
        try (Connection connection = dbInitializer.getCpds().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT *\n" +
                "FROM application.departments\n" +
                "ORDER BY id ASC\n" +
                "LIMIT ? OFFSET ?")) {
            preparedStatement.setLong(1, limit);
            preparedStatement.setLong(2, offset);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Department department = new Department();
                    department.setId(resultSet.getLong(1));
                    department.setName(resultSet.getString(2));
                    if (resultSet.getLong(1) != resultSet.getLong(3)) {
                        department.setParent_dep(this.getDepartment(resultSet.getLong(3)));
                    } else {
                        Department parentDep = new Department();
                        parentDep.setName("Не имеет родительского отдела");
                        department.setParent_dep(parentDep);
                    }
                    departments.add(department);
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка работы с Базой Данных -DEP", e);
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
                        department.setParent_dep(this.getDepartment(resultSet.getLong(3)));
                    } else {
                        Department parentDep = new Department();
                        parentDep.setName("Не имеет родительского отдела");
                        department.setParent_dep(parentDep);
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
