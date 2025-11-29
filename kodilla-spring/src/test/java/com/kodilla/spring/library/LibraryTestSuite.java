package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest(classes = LibraryConfig.class)
public class LibraryTestSuite {

    @Autowired
    Library library;

    @Test
    void testLoadFromDatabase() {
        library.loadFromDb();
    }

    @Test
    void testSaveToDatabase() {
        library.saveToDb();
    }

    @Test
    void testContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");

        System.out.println("===== Beans list: ==== >");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }
}
