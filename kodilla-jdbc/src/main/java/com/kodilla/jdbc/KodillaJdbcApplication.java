package com.kodilla.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KodillaJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(KodillaJdbcApplication.class, args);
    }

    public static int[][] convertMother(int[][] mother) {
        int[][] matrix = new int[mother[0].length][mother.length];

        System.out.println("Converting mother " + mother.length + " x " + mother[0].length + " to matrix..." + matrix.length + " x " + matrix[0].length);

        for (int i = 0; i < mother.length; i++) {
            for(int j = 0; j < mother[0].length; j++) {
                matrix[j][i] = mother[i][j];
            }
        }
        System.out.println("Result matrix:");
        printArray(matrix);

        return matrix;
    }

    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

}
