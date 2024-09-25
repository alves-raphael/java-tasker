package org.example.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private final List<Task> tasks;
    private final Scanner scanner;

    public TaskManager() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1 - New Task");
            System.out.println("2 - Show Tasks");
            System.out.println("3 - Delete Task");
            System.out.println("4 - Check");
            System.out.println("5 - Exit");
            System.out.print("Insert a number: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addTask();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    check();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addTask() {
        System.out.print("Insert task title: ");
        String description = scanner.nextLine();
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    private void show() {
        if (tasks.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        tasks.forEach(System.out::println);
    }

    private void remove() {
        System.out.print("Enter task ID to remove: ");
        int id = scanner.nextInt();
        tasks.removeIf(task -> task.getId() == id);
        System.out.println("Task with ID " + id + " removed.");
    }

    private void check() {
        System.out.print("Insert task ID to check: ");
        int id = scanner.nextInt();
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(true);
                System.out.println("Task marked as completed: " + task);
                return;
            }
        }
        System.out.println("Task with ID " + id + " not found.");
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.start();
    }
}
