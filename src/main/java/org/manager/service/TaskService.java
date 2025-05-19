package org.manager.service;

import org.manager.helper.StringHelper;
import org.manager.model.Task;
import org.manager.repository.TaskRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static org.manager.helper.StringHelper.booleanToString;
import static org.manager.helper.StringHelper.dateToString;

public class TaskService {
    public static Scanner scanner = new Scanner(System.in);

    public static void create() throws SQLException {
        System.out.println("Enter description: ");
        String desc = scanner.nextLine();
        LocalDate localDate = LocalDate.now();
        Date startDate = Date.valueOf(localDate);
        Task task = new Task(desc, startDate);
        TaskRepository.createTask(task);
    }

    public static void updateDescription() throws SQLException {
        System.out.println("Update description of task: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Update description to: ");
        String updatedDesc = scanner.nextLine();
        TaskRepository.editTaskDescription(updatedDesc, id);
    }

    public static void finishTask() throws SQLException {
        System.out.println("Task finished(id): ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        TaskRepository.updateTaskStatus(id, true);
    }

    public static void unDoneTask() throws SQLException {
        System.out.println("Task undone(id): ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        TaskRepository.updateTaskStatus(id, false);
    }

    public static void tableView(List<Task> tasks) {
        System.out.println("\n=== All Tasks ===");
        System.out.println("=========================================================================================================================");
        System.out.println(" ID | Description                                                             |     Start     |     End       | Status");
        System.out.println("----+-------------------------------------------------------------------------+-----------+-----------+------------------");
        for (Task task : tasks) {
            TaskService.printWrappedRow(task.getId(), task.getDescription(), task.getStartDate().toString(), dateToString(task.getEndDate()), booleanToString(task.isStatus()));
            System.out.println("----+-------------------------------------------------------------------------+-----------+-----------+------------------");
        }
    }

    public static void printWrappedRow(int id, String desc, String startDate, String endDate, String status) {
        int descWidth = 69;
        List<String> wrappedLines = StringHelper.wrapTextByWords(desc, descWidth);

        for (int i = 0; i < wrappedLines.size(); i++) {
            String line = wrappedLines.get(i);
            if (i == 0) {
                System.out.printf(" %-2d | %-69s   | %-13s | %-13s | %-10s%n", id, desc, startDate, endDate, status);
            }
            else {
                System.out.printf("    | %-69s   |               |               |           %n", line);
            }
        }
    }

    public static void allTasks() throws SQLException {
        List<Task> tasks = TaskRepository.listAllTasks();
        tableView(tasks);
    }

    public static void allTasksInDate() throws SQLException {
        List<Task> tasks = TaskRepository.listAllTasksInDate();
        tableView(tasks);
    }

    public static void allRemainingTasks() throws SQLException {
        List<Task> tasks = TaskRepository.listAllRemainingTask();
        tableView(tasks);
    }

    public static void delete(int taskId) throws SQLException {
        TaskRepository.deleteTask(taskId);
    }
}
