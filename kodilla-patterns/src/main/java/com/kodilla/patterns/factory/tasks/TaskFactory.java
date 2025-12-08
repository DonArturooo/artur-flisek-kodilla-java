package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    static final String DRIVING_TASK = "DRIVING_TASK";
    static final String PAINTING_TASK = "PAINTING_TASK";
    static final String SHOPPING_TASK = "SHOPPING_TASK";

    public Task createTask(String taskName, String... args) {
        return switch (taskName) {
            case SHOPPING_TASK -> new ShoppingTask(args[0], args[1], Double.parseDouble(args[2]));
            case PAINTING_TASK -> new PaintingTask(args[0], args[1], args[2]);
            case DRIVING_TASK -> new DrivingTask(args[0], args[1], args[2]);
            default -> null;
        };
    }
}
