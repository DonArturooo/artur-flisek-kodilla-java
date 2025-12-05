package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {

    @Test
    void testGetLastLog() {
        Logger logger = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;

        assertAll(() -> {
            logger.log("Pierwszy log");
            assertEquals("Pierwszy log", logger.getLastLog());
            assertEquals("Pierwszy log", logger2.getLastLog());
        }, () -> {
            logger.log("Drugi log");
            assertEquals("Drugi log", logger.getLastLog());
            assertEquals("Drugi log", logger2.getLastLog());
        }, () -> {
            logger2.log("Trzeci log");
            assertEquals("Trzeci log", logger.getLastLog());
            assertEquals("Trzeci log", logger2.getLastLog());
        });
    }
}
