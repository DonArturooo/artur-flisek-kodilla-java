package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Forum Test Suite")
public class ForumTestSuite {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Test Case: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test Case: end");
    }

    @DisplayName(
            "When created SimpleUser with name, " +
                    "then getUsername should return correct name"
    )
    @Test
    void testCaseUsername() {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        Assertions.assertEquals("theForumUser", simpleUser.getUsername());
    }

    @DisplayName(
            "When created SimpleUser with realName, " +
                    "then getRealName should return real user name"
    )
    @Test
    void testCaseRealName() {
        SimpleUser simpleUser = new SimpleUser("theForumUser", "Artur Flisek");

        Assertions.assertEquals("Artur Flisek", simpleUser.getRealName());
    }

}
