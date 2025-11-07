package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain  {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("Calculator - testy jednostkowe:");

        if ( calculator.add(2, 2 ) == 4 ){
            System.out.println("Metoda add działa poprawnie");
        } else  {
            System.out.println("Error!");
        }

        if ( calculator.subtract(2, 2 ) == 0 ){
            System.out.println("Metoda subtract działa poprawnie");
        } else  {
            System.out.println("Error!");
        }
    }
}
