package com.example.taskmanagent;

import java.util.Date;

public class ShoppingTask implements Task {
    private String taskName;
    private String taskDescription;
    private boolean isComplete;
    private Priority priority;
    private Date deadline;
    private String shoppingPlace;

    public ShoppingTask() {
        isComplete = false;
    }

    @Override
    public void setTask(String taskName, String taskDescription) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    @Override
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public void markAsComplete() {
        isComplete = true;
    }

    @Override
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public void setDeadline(Date date) {
        this.deadline = date;
    }

    public void setShoppingPlace(String shoppingPlace) {
        this.shoppingPlace = shoppingPlace;
    }

    @Override
    public String toString() {
        return "ShoppingTask: " + taskName + ", Description: " + taskDescription + ", Priority: " + priority + ", Deadline: " + deadline + ", Completed: " + isComplete + ", Shopping Place: " + shoppingPlace;
    }
}

