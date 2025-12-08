package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {
    Millenials millenials = new Millenials("Artur Flisek");
    YGeneration yGeneration = new YGeneration("Artur Flisek");
    ZGeneration zGeneration = new ZGeneration("Artur Flisek");

    @Test
    void testDefaultSharingStrategies() {
        assertAll(
                () -> assertEquals("Twitter", millenials.sharePost()),
                () -> assertEquals("Facebook", yGeneration.sharePost()),
                () -> assertEquals("Snapchat", zGeneration.sharePost()));
    }

    @Test
    void testIndividualSharingStrategy() {
        millenials.setSocialPublisher(new SnapchatPublisher());

        assertAll(
                () -> assertEquals("Snapchat", millenials.sharePost()),
                () -> assertEquals("Facebook", yGeneration.sharePost()),
                () -> assertEquals("Snapchat", zGeneration.sharePost()));
    }
}
