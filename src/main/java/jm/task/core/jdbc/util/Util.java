package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/antonio";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Soloplatinum321";

    private static Connection connection;

    public static Connection getConnection () {
        if (connection != null) {
            return connection;
        }

        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            return conn;
        } catch (SQLException e) {
            System.out.println("There is no connection... Exception!");
        }

        return null;
    }

    public static SessionFactory getSessionFactory () {
        return null;
    }

}
