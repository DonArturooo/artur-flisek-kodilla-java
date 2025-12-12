package com.kodilla.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;

@SpringBootApplication
public class KodillaPatternsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KodillaPatternsApplication.class, args);

        try {
            System.out.println(KodillaPatternsApplication.fibonacci(155));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
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
}
