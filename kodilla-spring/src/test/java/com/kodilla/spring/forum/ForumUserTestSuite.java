package com.kodilla.spring.forum;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForumUserTestSuite {

    @Test
    void testGetUsername(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.kodilla.spring.forum");

        ForumUser forumUser = applicationContext.getBean(ForumUser.class);

        assertEquals("John Smith", forumUser.userName);
    }
}
