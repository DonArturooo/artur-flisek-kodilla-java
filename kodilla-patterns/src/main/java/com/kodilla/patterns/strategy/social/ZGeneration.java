package com.kodilla.patterns.strategy.social;

public final class ZGeneration extends User {

    public ZGeneration(String userName) {
        super(userName, new SnapchatPublisher());
    }
}
