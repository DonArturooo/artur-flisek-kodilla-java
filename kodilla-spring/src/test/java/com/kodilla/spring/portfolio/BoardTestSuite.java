package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = BoardConfig.class)
public class BoardTestSuite {

    @Autowired
    private Board board;

    @Test
    void testAddTask() {
        board.addToDoTask("Iść spać");
        board.addInProgressTask("Zakończyć moduł 10");
        board.addDoneTask("Zakończyć testy jednostkowe do zadania");

        assertAll(
                () -> assertEquals("Nauka java, Trening na siłowni, Iść spać", board.getToDoList()),
                () -> assertEquals("Kodilla bootcamp, 100kg na płaskiej, Zakończyć moduł 10", board.getInProgressList()),
                () -> assertEquals("Zadanie 3 z modułu 10, Zakończyć testy jednostkowe do zadania", board.getDoneList())
        );
    }

    @Test
    void testTaskBoard() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

        Board board = context.getBean(Board.class);

        assertAll(
                () -> assertEquals("Nauka java, Trening na siłowni", board.getToDoList()),
                () -> assertEquals("Kodilla bootcamp, 100kg na płaskiej", board.getInProgressList()),
                () -> assertEquals("Zadanie 3 z modułu 10", board.getDoneList())
        );
    }
}
