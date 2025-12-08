package com.kodilla.patterns.strategy.social;

public sealed class User permits Millenials, YGeneration, ZGeneration {
    final String userName;
    private SocialPublisher socialPublisher;

    public User(String userName, SocialPublisher socialPublisher) {
        this.userName = userName;
        this.socialPublisher = socialPublisher;
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public String sharePost() {
        return socialPublisher.share();
    }
}
