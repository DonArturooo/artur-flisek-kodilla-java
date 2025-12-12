package com.kodilla.testing.loop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testLoopAndConditionalBreakpoints {
    @Test
    void testLoop(){
        long sum  = 0;

        for (long i = 0; i < 1000; i++) {
            sum += i;
            System.out.println("[" + i + "] Sum equals: " + sum);
        }

        assertEquals(499500, sum);
    }
}
