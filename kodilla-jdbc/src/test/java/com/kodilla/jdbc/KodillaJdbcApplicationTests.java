package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.kodilla.jdbc.KodillaJdbcApplication.convertMother;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KodillaJdbcApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void testConvertMother() {
        //Given
        int[][] mother = new int[][]{{5,3,-2},{-7,4,8},{2,7,1},{9,5,3}};
        int[][] result = new int[][]{{5, -7, 2, 9},{3, 4, 7, 5},{-2, 8, 1, 3}};

        //When
        int[][] matrix = convertMother(mother);

        //Then
        assertAll(
                () -> assertEquals(matrix.length, mother[0].length),
                () -> assertEquals(matrix[0].length, mother.length),
                () -> assertArrayEquals(matrix[0], result[0], "Wrong matrix"),
                () -> assertArrayEquals(matrix[1], result[1], "Wrong matrix"),
                () -> assertArrayEquals(matrix[2], result[2], "Wrong matrix")
        );
    }
}
