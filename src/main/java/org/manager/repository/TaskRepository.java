package org.manager.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.manager.model.Task;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private static DataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/jdbc_todolist");
        dataSource.setUsername("root");
        dataSource.setPassword("dung20022014");
        return dataSource;
    }

    public static void createTableTask() throws SQLException {
        Connection connection = getDataSource().getConnection();
        String createTableTask = "CREATE TABLE IF NOT EXISTS TASK (ID INT PRIMARY KEY, TASK_DESCRIPTION VARCHAR(255))";
        Statement statement = connection.createStatement();
        statement.execute(createTableTask);
    }

    public static void createTask() {

    }

    public static void editTask(Task task) {

    }

    public static List<Task> listAllTask() {
        List<Task> tasks = new ArrayList<>();
        return tasks;
    }

    public static void deleteTask(int id) {

    }

    public static void deleteAllTask() {

    }

    public static void main(String[] args) throws SQLException {
        System.out.println("hello");
        createTableTask();
    }
}
