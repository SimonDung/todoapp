package org.manager;

import java.sql.*;
import java.time.LocalDate;
//import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        String url = "jdbc:mysql:./db/todolist.db";
//        try (Connection connection = DriverManager.getConnection(url)) {
//            System.out.println("Connection to SQLite has been established.");
//            String createTable = "CREATE TABLE IF NOT EXISTS TASK (ID IDENTITY PRIMARY KEY, DESCRIPTION VARCHAR, DATE DATE)";
//            Statement statement = connection.createStatement();
//            statement.execute(createTable);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
        LocalDate localDate = LocalDate.now();
        Date date = Date.valueOf(localDate);
        System.out.println(date);
    }
}