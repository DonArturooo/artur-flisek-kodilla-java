package com.kodilla.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class KodillaHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(KodillaHibernateApplication.class, args);
        findSecondMinAndMaxSimple(3,1,1,5,6,7,9,15,3,4,7,10);
        findSecondMinAndMaxSort(3,1,1,5,6,7,9,15,3,4,7,10);
    }

    public static void findSecondMinAndMaxSimple(int... numbers) {
        int min = numbers[0];
        int secondMin = numbers[0];
        int max = numbers[0];
        int secondMax = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min){
                secondMin = min;
                min = numbers[i];
            }
            if(numbers[i] < secondMin && numbers[i] != min){
                secondMin = numbers[i];
            }

            if (numbers[i] > max) {
                secondMax = max;
                max = numbers[i];
            }
            if(numbers[i] > secondMax && numbers[i] != max){
                secondMax = numbers[i];
            }
        }

        System.out.println("Second MIN: " + secondMin +  ", Second MAX: " + secondMax);
    }

    public static void findSecondMinAndMaxSort(int... numbers) {
        ArrayList<Integer> sorted = new ArrayList<>();

        for (int number : numbers) {
            sorted.add(number);
        }

        sorted.sort(Comparator.comparingInt(a -> a));

        List<Integer> distinct = sorted.stream().distinct().toList();

        System.out.println("Second MIN: " + distinct.get(1) +  ", Second MAX: " + distinct.get(distinct.size() - 2));
    }

}
