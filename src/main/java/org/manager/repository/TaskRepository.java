package org.manager.repository;

import com.zaxxer.hikari.HikariDataSource;
import jdk.javadoc.doclet.DocletEnvironment;
import org.manager.model.Task;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private static DataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(System.getenv("JDBC_URL"));
        dataSource.setUsername(System.getenv("DB_USERNAME"));
        dataSource.setPassword(System.getenv("DB_PASSWORD"));
        return dataSource;
    }

    public static void createTableTask() throws SQLException {
        Connection connection = getDataSource().getConnection();
        String createTableTask = "CREATE TABLE IF NOT EXISTS TASK (ID INT PRIMARY KEY AUTO_INCREMENT, TASK_DESCRIPTION TEXT, START_DATE DATE, END_DATE DATE, TASK_STATUS BOOLEAN)";
        Statement statement = connection.createStatement();
        statement.execute(createTableTask);
    }

    public static void dropTableTask() throws SQLException {
        Connection connection = getDataSource().getConnection();
        String dropTableTask = "DROP TABLE TASK";
        Statement statement = connection.createStatement();
        statement.execute(dropTableTask);
    }

    public static void createTask(Task task) throws SQLException {
        Connection connection = getDataSource().getConnection();
        String insertTask = "INSERT INTO TASK (TASK_DESCRIPTION, START_DATE, END_DATE, TASK_STATUS) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertTask);
        preparedStatement.setString(1, task.getDescription());
        preparedStatement.setDate(2, task.getStartDate());
        preparedStatement.setDate(3, task.getEndDate());
        preparedStatement.setBoolean(4, task.isStatus());
        preparedStatement.execute();
    }

    public static void editTaskDescription(String description, Integer id) throws SQLException {
        Connection connection = getDataSource().getConnection();
        String updateTaskDesc = "UPDATE TASK SET TASK_DESCRIPTION = ? WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateTaskDesc);
        preparedStatement.setString(1, description);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public static void updateTaskStatus(int id, boolean status) throws SQLException {
        Connection connection = getDataSource().getConnection();
        String updateTaskStatus = "UPDATE TASK SET TASK_STATUS = ? WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateTaskStatus);
        preparedStatement.setBoolean(1, status);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public static List<Task> listAllTasks() throws SQLException {
        Connection connection = getDataSource().getConnection();
        List<Task> tasks = new ArrayList<>();
        String selectAllTasks = "SELECT * FROM TASK";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectAllTasks);
        while (resultSet.next()) {
            Task task = new Task(resultSet.getInt(1),
                                 resultSet.getString(2),
                                 resultSet.getDate(3),
                                 resultSet.getDate(4),
                                 resultSet.getBoolean(5));
            tasks.add(task);
        }
        return tasks;
    }

    public static List<Task> listAllTasksInDate() throws SQLException {
        Connection connection = getDataSource().getConnection();
        List<Task> tasks = new ArrayList<>();
        String selectAllTasksToday = "SELECT * FROM TASK WHERE START_DATE = ?";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectAllTasksToday);
        while (resultSet.next()) {
            Task task = new Task(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getDate(3),
                    resultSet.getDate(4),
                    resultSet.getBoolean(5));
            tasks.add(task);
        }
        return tasks;
    }

    public static List<Task> listAllRemainingTask() throws SQLException {
        Connection connection = getDataSource().getConnection();
        List<Task> tasks = new ArrayList<>();
        String selectAllTasksToday = "SELECT * FROM TASK WHERE TASK_STATUS = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectAllTasksToday);
        preparedStatement.setBoolean(1, false);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Task task = new Task(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getDate(3),
                    resultSet.getDate(4),
                    resultSet.getBoolean(5));
            tasks.add(task);
        }
        return tasks;
    }

    public static void deleteTask(int id) throws SQLException {
        Connection connection = getDataSource().getConnection();
        List<Task> tasks = new ArrayList<>();
        String deleteTask = "DELETE FROM TASK WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteTask);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public static void main(String[] args) throws SQLException {
        // Create table
//        createTableTask();

        // Create task
//        LocalDate localDate = LocalDate.now();
//        Date date = Date.valueOf(localDate);
//        Task task = new Task("Omega gaga", date);
//        createTask(task);

        // List all task
//        for (Task task : listAllTasks()) {
//            System.out.println(task.getId());
//            System.out.println(task.getDescription());
//            System.out.println(task.getStartDate());
//            System.out.println(task.getEndDate());
//            System.out.println(task.isStatus());
//            System.out.println("--------------------------------");
//        }

        // List all remaining task
//        for (Task task : listAllRemainingTask()) {
//            System.out.println(task.getId());
//            System.out.println(task.getDescription());
//            System.out.println(task.getStartDate());
//            System.out.println(task.getEndDate());
//            System.out.println(task.isStatus());
//            System.out.println("--------------------------------");
//        }

        // Edit task description
        //editTaskDescription("merry on the wall", 1);

        // Update Task status
//        int id = 1;
//        boolean status = true;
//        updateTaskStatus(id, status);

        // Delete task
//        int id = 1;
//        deleteTask(id);

        //Drop table
//        dropTableTask();
    }
}
