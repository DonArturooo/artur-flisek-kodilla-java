package com.kodilla.stream.portfolio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Board {
    private final List<TaskList> taskLists = new ArrayList<>();
    private final String name;

    public Board(final String name) {
        this.name = name;
    }

    public void addTaskList(TaskList taskList) {
        taskLists.add(taskList);
    }

    public void removeTaskList(TaskList taskList) {
        taskLists.remove(taskList);
    }

    public List<TaskList> getTaskLists() {
        return new ArrayList<>(taskLists);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Board{" + "taskLists=" + taskLists + ", name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Board board = (Board) o;
        return Objects.equals(taskLists, board.taskLists) && Objects.equals(name, board.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskLists, name);
    }
}
