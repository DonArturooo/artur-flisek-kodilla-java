package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {Library.class, LibraryDbController.class})
public class LibraryTestSuite {

//    ApplicationContext applicationContext;
//    Library library;

//    @BeforeEach
//    void  init()
//    {
//        applicationContext = new AnnotationConfigApplicationContext("com.kodilla.spring.library");
//        library = applicationContext.getBean(Library.class);
//    }

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
}
