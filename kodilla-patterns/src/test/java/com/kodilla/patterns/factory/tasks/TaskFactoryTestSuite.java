package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {
    TaskFactory factory = new TaskFactory();

    Task task1 = factory.createTask(TaskFactory.SHOPPING_TASK, "Kup mleko", "milk", "2");
    Task task2 = factory.createTask(TaskFactory.PAINTING_TASK, "Namaluj drzewo", "brown", "tree");
    Task task3 = factory.createTask(TaskFactory.DRIVING_TASK, "Jedź do Włoch", "Italy", "car");

    Task nullTask = factory.createTask("Coś");

    @Test
    void testCreateTask() {
        assertAll(
                () -> assertEquals("Kup mleko", task1.getTaskName()),
                () -> assertEquals("Namaluj drzewo", task2.getTaskName()),
                () -> assertEquals("Jedź do Włoch", task3.getTaskName()),
                () -> assertNull(nullTask)
        );
    }

    @Test
    void testExecuteTask() {
        task1.executeTask();
        task3.executeTask();

        assertAll(
                () -> assertTrue(task1.isTaskExecuted()),
                () -> assertFalse(task2.isTaskExecuted()),
                () -> assertTrue(task3.isTaskExecuted())
        );
    }
}
