package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // Создание таблицы пользователей
        userService.createUsersTable();


        userService.saveUser("Иван", "Иванов", (byte) 25);
        System.out.println("User с именем Иван добавлен в базу данных");

        userService.saveUser("Петр", "Петров", (byte) 30);
        System.out.println("User с именем Петр добавлен в базу данных");

        userService.saveUser("Сергей", "Сергеев", (byte) 35);
        System.out.println("User с именем Сергей добавлен в базу данных");

        userService.saveUser("Алексей", "Алексеев", (byte) 40);
        System.out.println("User с именем Алексей добавлен в базу данных");

        // Получение всех пользователей из базы и вывод в консоль
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        // Очистка таблицы пользователей
        userService.cleanUsersTable();

        // Удаление таблицы пользователей
        userService.dropUsersTable();


    }
}
