package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Ivan", "Ivanov", (byte) 30);
        System.out.println("User с именем - Ivan добавлен в базу данных");

        userDao.saveUser("Petr", "Petrov", (byte) 35);
        System.out.println("User с именем - Petr добавлен в базу данных");

        userDao.saveUser("Sergey", "Sergeev", (byte) 25);
        System.out.println("User с именем - Sergey добавлен в базу данных");

        userDao.saveUser("Nikolay", "Nikolaev", (byte) 45);
        System.out.println("User с именем - Nikolay добавлен в базу данных");

        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}