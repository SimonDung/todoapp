package org.manager.service;

import org.manager.repository.TaskRepository;

public class TaskService {
    public TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public static void tableView() {
        System.out.println("\n=== All Tasks ===");
        System.out.println("==============================================================================================================");
        System.out.println(" ID | Description                                                             | Start     | End       | Status");
        System.out.println("----+-------------------------------------------------------------------------+-----------+-----------+-------");
    }


}
