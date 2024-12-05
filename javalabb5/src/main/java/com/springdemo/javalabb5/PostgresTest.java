package com.springdemo.javalabb5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/task_app";
        String username = "postgres";
        String password = "1234567";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
