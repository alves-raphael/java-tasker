package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private static final AtomicInteger idGenerator = new AtomicInteger();
    private int id;
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.id = idGenerator.incrementAndGet();
        this.description = description;
        this.isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isCompleted=" + (isCompleted ? "Completed" : "Pending") +
                '}';
    }
}