package com.kodilla.spring.portfolio;

public class Board {
    final TaskList toDoList, inProgressList, doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public String getToDoList() {
        return String.join(", ", toDoList.getTaskList());
    }

    public String getInProgressList() {
        return String.join(", ", inProgressList.getTaskList());
    }

    public String getDoneList() {
        return String.join(", ", doneList.getTaskList());
    }

    public void addToDoTask(String task){
        toDoList.addTask(task);
    }

    public void addInProgressTask(String task){
        inProgressList.addTask(task);
    }

    public void addDoneTask(String task){
        doneList.addTask(task);
    }
}
