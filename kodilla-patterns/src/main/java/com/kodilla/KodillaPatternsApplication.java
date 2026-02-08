package com.kodilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;

@SpringBootApplication
public class KodillaPatternsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KodillaPatternsApplication.class, args);

//        try {
//            System.out.println(KodillaPatternsApplication.fibonacci(155));
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//
//        System.out.println("Dla wartości 3,1,5,6,7,9,15,3,4,7,10");
//        KodillaPatternsApplication.findMinAndMaxSimple(3,1,5,6,7,9,15,3,4,7,10);
//        KodillaPatternsApplication.findMinAndMaxSort(3,1,5,6,7,9,15,3,4,7,10);
//
//        System.out.println("Dla wartości 8, 2, 14, 6, 9");
//        KodillaPatternsApplication.findMinAndMaxSimple(8, 2, 14, 6, 9);
//        KodillaPatternsApplication.findMinAndMaxSort(8, 2, 14, 6, 9);
//
//        System.out.println("Dla wartości -3, -7, -1, -20, -4");
//        KodillaPatternsApplication.findMinAndMaxSimple(-3, -7, -1, -20, -4);
//        KodillaPatternsApplication.findMinAndMaxSort(-3, -7, -1, -20, -4);
//
//        System.out.println("Dla wartości -10, 5, 0, 23, -7, 8");
//        KodillaPatternsApplication.findMinAndMaxSimple(-10, 5, 0, 23, -7, 8);
//        KodillaPatternsApplication.findMinAndMaxSort(-10, 5, 0, 23, -7, 8);
//
//        System.out.println("Dla wartości 42");
//        KodillaPatternsApplication.findMinAndMaxSimple(42);
//        KodillaPatternsApplication.findMinAndMaxSort(42);
//
//        System.out.println("Dla wartości 5, 5, 5, 5, 5");
//        KodillaPatternsApplication.findMinAndMaxSimple(5, 5, 5, 5, 5);
//        KodillaPatternsApplication.findMinAndMaxSort(5, 5, 5, 5, 5);
//
//        System.out.println("Dla wartości 1000, -1000, 500, -500, 0");
//        KodillaPatternsApplication.findMinAndMaxSimple(1000, -1000, 500, -500, 0);
//        KodillaPatternsApplication.findMinAndMaxSort(1000, -1000, 500, -500, 0);
//
//        System.out.println("Dla wartości 9, 1, 8, 2, 7, 3, 6, 4, 5");
//        KodillaPatternsApplication.findMinAndMaxSimple(9, 1, 8, 2, 7, 3, 6, 4, 5);
//        KodillaPatternsApplication.findMinAndMaxSort(9, 1, 8, 2, 7, 3, 6, 4, 5);

        System.out.println(convertIntToBinary(-10));
    }


    public static BigInteger fibonacci(int index, BigInteger... numbers) throws Exception {
        if (index < 0) throw new Exception("Wartość powinna być większa od zera");
        BigInteger current, next;

        if(numbers == null || numbers.length == 0){
            current = BigInteger.ZERO;
            next = BigInteger.ONE;
        } else {
            current = numbers[0];
            next = numbers[1];
        }

        if(index == 0){
            return current;
        }
        else {
            return fibonacci(index - 1, next, next.add(current));
        }
    }

    public static void findMinAndMaxSimple(int... numbers) {
        int min = numbers[0];
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) min = numbers[i];
            if (numbers[i] > max) max = numbers[i];
        }

        System.out.println("MIN: " + min +  ", MAX: " + max);
    }

    public static void findMinAndMaxSort(int... numbers) {
        ArrayList<Integer> sorted = new ArrayList<>();

        for (int number : numbers) {
            sorted.add(number);
        }

        sorted.sort(Comparator.comparingInt(a -> a));

        System.out.println("MIN: " + sorted.getFirst() +  ", MAX: " + sorted.getLast());
    }

    public static String convertIntToBinary(int number) {
        if (number == 0) return "0";
        if (number == 1) return "1";
        if (number < 0) return "-" + convertIntToBinary(-number);

        return convertIntToBinary(number / 2) + number % 2;
    }
}
