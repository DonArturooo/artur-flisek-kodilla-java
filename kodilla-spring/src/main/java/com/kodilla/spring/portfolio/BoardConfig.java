package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BoardConfig {

    @Bean(name = "todo")
    public TaskList getTodoTaskList() {
        List<String> todos = new ArrayList<>();

        todos.add("Nauka java");
        todos.add("Trening na siłowni");

        return new TaskList(todos);
    }

    @Bean(name = "inProgress")
    public TaskList getInProgressTaskList() {
        List<String> inProgress = new ArrayList<>();

        inProgress.add("Kodilla bootcamp");
        inProgress.add("100kg na płaskiej");

        return new TaskList(inProgress);
    }

    @Bean(name = "done")
    public TaskList getDoneTaskList() {
        List<String> done = new ArrayList<>();

        done.add("Zadanie 3 z modułu 10");

        return new TaskList(done);
    }

    @Bean
    public Board getBoard(@Qualifier("todo") TaskList todo, @Qualifier("inProgress") TaskList inProgress, @Qualifier("done") TaskList done) {
        return new Board(todo, inProgress, done);
    }
}
