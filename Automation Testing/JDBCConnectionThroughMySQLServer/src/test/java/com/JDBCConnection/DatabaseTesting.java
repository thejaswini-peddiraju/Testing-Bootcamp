package com.JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTesting {

    private Connection connection;

    public void establishedDatabaseConnection()
            throws ClassNotFoundException, SQLException {

        String databaseURL = "jdbc:mysql://localhost:3306/SeleniumAutomation";

        String user = "root";
        String password = "Thejaswini@123";

        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("Connecting to Database");

        connection = DriverManager.getConnection(databaseURL, user, password);

        if (connection == null) {
            System.out.println("Database connection failed");
        } else {
            System.out.println("Database connection Successful");
        }
    }
}