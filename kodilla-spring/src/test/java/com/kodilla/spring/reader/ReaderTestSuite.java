package com.kodilla.spring.reader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest(classes = ReaderConfig.class)
public class ReaderTestSuite {

    @Autowired
    Reader reader;

    @Test
    void testRead() {
        reader.read();
    }

    @Test
    void testConditional() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);

        System.out.println("Bean book2 was found in the container: " + context.containsBean("book2"));
    }
}
