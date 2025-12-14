package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/stringfunifier";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123";
    private static Connection connection;


    public static Connection getConnection() throws SQLException {
        if (connection != null) {
            return connection;
        } else {
            try {
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println("Connection established.");
                return connection;
            } catch (SQLException e) {
                System.out.println("Start Connection failed");
                System.out.println(e.getMessage());
                return null;
            }
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("connection closed");
            }
        } catch (SQLException e) {
            System.out.println("Closing Connection failed");
        }
    }
}
