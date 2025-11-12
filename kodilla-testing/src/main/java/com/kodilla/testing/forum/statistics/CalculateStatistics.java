package com.kodilla.testing.forum.statistics;

public class CalculateStatistics {
    private int userCount, postsCount, commentsCount;
    private int averagePosts, averageComments, averageCommentsOnPosts;

    public void calculateAdvStatistics(Statistics statistics){
        userCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();

        averagePosts = userCount > 0 ? postsCount / userCount : 0;
        averageComments = userCount > 0 ? commentsCount / userCount : 0;
        averageCommentsOnPosts = postsCount > 0 ? commentsCount / postsCount : 0;
    }

    public int getUserCount() {
        return userCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public int getAveragePosts() {
        return averagePosts;
    }

    public int getAverageComments() {
        return averageComments;
    }

    public int getAverageCommentsOnPosts() {
        return averageCommentsOnPosts;
    }

    public void showStatistics(){
        System.out.printf("""
                Total user: %d,
                Total posts: %d,
                Total comments: %d,
                Posts on user: %d,
                Comments on user: %d
                Comments on post: %d
                %n""", userCount, postsCount, commentsCount, averagePosts, averageComments, averageCommentsOnPosts);
    }
}
