package com.kodilla.spring.kodillaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;

@SpringBootApplication
public class KodillaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(KodillaSpringApplication.class, args);

        try {
            System.out.println(KodillaSpringApplication.fibonacci(155));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static BigInteger fibonacci(int number) throws Exception {
        if (number < 0) throw new Exception("Wartość powinna być większa od zera");

        if(number == 0) return BigInteger.ZERO;

        if(number == 1) return BigInteger.ONE;

        if(number == 2) return BigInteger.ONE;

        BigInteger result = BigInteger.ONE;
        BigInteger last = BigInteger.ONE;
        BigInteger previous = BigInteger.ONE;

        for (int i = 3; i <= number; i++) {
            result = last.add(previous);
            previous = last;
            last = result;
        }

        return result;
    }

}
