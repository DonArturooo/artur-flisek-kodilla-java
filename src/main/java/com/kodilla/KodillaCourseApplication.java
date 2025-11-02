package com.kodilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class KodillaCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(KodillaCourseApplication.class, args);

        List<Integer> list = subZero(11, 145, 3);
        System.out.println(list);

    }

    //Funkcja dzieląca
    public static List<Integer> subZero (int first, int last, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i = first; i <= last; i++) {
            if(i%x==0){
                list.add(i);
            }
        }
        return  list;
    }

}
