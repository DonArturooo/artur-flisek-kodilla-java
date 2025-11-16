package com.kodilla.stream.array;

import org.junit.jupiter.api.*;

public class ArrayOperationsTestSuite {
    @Test
    void testGetAverage(){
        int[] numbers = new int[]{1,2,3,4,5,6,7,8,9,10};

        Assertions.assertEquals(5.5, ArrayOperations.getAverage(numbers));
    }
}
