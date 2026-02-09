package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {
    @Test
    public void testUpdate() {
        // Given
        Kursant artur = new Kursant("Artur");
        Kursant pawel = new Kursant("Paweł");
        Mentor jacek = new Mentor("Jacek");
        Mentor janusz = new Mentor("Janusz");

        artur.registerObserver(jacek);
        artur.registerObserver(janusz);
        pawel.registerObserver(janusz);

        // When
        artur.addTask(new Task("Zadanie 20.1"));
        artur.addTask(new Task("Zadanie 20.2"));
        artur.addTask(new Task("Zadanie 20.3"));
        artur.addTask(new Task("Zadanie 20.4"));

        pawel.addTask(new Task("Zadanie 20.5"));

        // Then
        assertAll(() -> assertEquals(4, jacek.getTotalTaskToCheck()), () -> assertEquals(5, janusz.getTotalTaskToCheck()));
    }
}
