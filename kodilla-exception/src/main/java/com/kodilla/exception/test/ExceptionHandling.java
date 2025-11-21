package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge challenge = new SecondChallenge();

        try {
            String string = challenge.probablyIWillThrowException(11, 23);
        } catch (Exception e) {
            System.out.println("Niestety poleciał błąd");
        }
    }
}
