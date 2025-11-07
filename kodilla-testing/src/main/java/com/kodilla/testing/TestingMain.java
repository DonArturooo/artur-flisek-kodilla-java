package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain  {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        Calculator calculator = new Calculator();

        System.out.println("SimpleUser - testy jednostkowe:");
        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Calculator - testy jednostkowe:");

        if ( calculator.add(2, 2 ) == 4){
            System.out.println("Metoda add działa poprawnie");
        } else  {
            System.out.println("Error!");
        }

        if ( calculator.subtract(2, 2 ) == 0){
            System.out.println("Metoda subtract działa poprawnie");
        } else  {
            System.out.println("Error!");
        }
    }
}
