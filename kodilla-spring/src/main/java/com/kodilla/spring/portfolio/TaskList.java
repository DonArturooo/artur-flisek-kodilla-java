package com.kodilla.spring.portfolio;

import java.util.List;

public class TaskList {
    final List<String> taskList;

    public TaskList(List<String> taskList) {
        this.taskList = taskList;
    }

    public List<String> getTaskList() {
        return taskList;
    }

    public void addTask(String task){
        taskList.add(task);
    }
}
