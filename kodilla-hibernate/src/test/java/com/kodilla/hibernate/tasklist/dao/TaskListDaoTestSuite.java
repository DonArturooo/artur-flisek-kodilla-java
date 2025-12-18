package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName(){
        TaskList todoList = new TaskList("ToDo", "Zadania do zrobienia");

        taskListDao.save(todoList);

        assertEquals(1, taskListDao.findByListName("ToDo").size());

        taskListDao.deleteById(todoList.getId());
    }
}
