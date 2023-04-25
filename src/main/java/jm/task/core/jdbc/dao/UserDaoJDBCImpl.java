package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao  {

    public UserDaoJDBCImpl() {


    }

    public void createUsersTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS users (id BIGINT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, age TINYINT NOT NULL)";
        try (Connection connection = Util.getConnection()) {
            assert connection != null;
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableSql);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при создании таблицы: " + e.getMessage());
        }
    }

    public void dropUsersTable() {
        String dropTableSql = "DROP TABLE IF EXISTS users";
        try (Connection connection = Util.getConnection()) {
            assert connection != null;
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(dropTableSql);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при удалении таблицы: " + e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String saveUserSql = "INSERT INTO users (name, lastName, age) VALUES ('" + name + "', '" + lastName + "', " + age + ")";
        try (Connection connection = Util.getConnection()) {
            assert connection != null;
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(saveUserSql);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при сохранении пользователя: " + e.getMessage());
        }
    }

    public void removeUserById(long id) {
        String removeUserSql = "DELETE FROM users WHERE id = " + id;
        try (Connection connection = Util.getConnection()) {
            assert connection != null;
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(removeUserSql);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при удалении пользователя: " + e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String getAllUsersSql = "SELECT * FROM users";

        try (Connection connection = Util.getConnection()) {
            assert connection != null;
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(getAllUsersSql)) {

                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setName(resultSet.getString("name"));
                    user.setLastName(resultSet.getString("lastName"));
                    user.setAge(resultSet.getByte("age"));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при получении пользователей: " + e.getMessage());
        }

        return users;
    }

    public void cleanUsersTable() {
        String cleanTableSql = "TRUNCATE TABLE users";
        try (Connection connection = Util.getConnection()) {
            assert connection != null;
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(cleanTableSql);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при очистке таблицы: " + e.getMessage());
        }
    }
}