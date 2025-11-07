package com.kodilla.testing.collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.ArrayList;
import java.util.Arrays;

@DisplayName("Forum Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    public void beforeEach(TestInfo testInfo) {
        System.out.println("Test Case: " + testInfo.getDisplayName() + " begin");
    }

    @AfterEach
    public void afterEach(TestInfo testInfo) {
        System.out.println("Test Case: "  + testInfo.getDisplayName() + " end");
    }

    @DisplayName(
            "When OddNumbersExterminator get empty list return empty list"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        OddNumbersExterminator exterminator = new OddNumbersExterminator();

        Assertions.assertEquals(new ArrayList<>(), exterminator.exterminate(new ArrayList<>()));
    }

    @DisplayName(
            "When OddNumbersExterminator get list of numbers exterminate odd numbers and return list of even numbers"
    )
    @Test
    void testOddNumbersExterminatorNormalList() {
        OddNumbersExterminator exterminator = new OddNumbersExterminator();

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Integer[] evenNumbers = {2, 4, 6, 8, 10};

        Assertions.assertEquals(Arrays.asList(evenNumbers), exterminator.exterminate(Arrays.asList(numbers)));
    }

}
