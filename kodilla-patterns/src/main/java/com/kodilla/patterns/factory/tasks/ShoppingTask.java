package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    private final String taskName, whatToBuy;
    double quantity;
    private boolean done = false;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing Shopping Task " + taskName);
        done = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return done;
    }
}
