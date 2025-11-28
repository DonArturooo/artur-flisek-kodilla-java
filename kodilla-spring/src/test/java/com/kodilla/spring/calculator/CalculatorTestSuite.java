package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {Display.class, Calculator.class})
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        assertAll(
                () -> assertEquals(9.0, calculator.add(4, 5)),
                () -> assertEquals(-1.0, calculator.sub(4, 5)),
                () -> assertEquals(20.0, calculator.mul(4, 5)),
                () -> assertEquals(0.8, calculator.div(4, 5))
        );
    }
}
