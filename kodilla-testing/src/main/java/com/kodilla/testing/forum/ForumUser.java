package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForumUser {
    private String userName, realName;
    private List<ForumComment> comments = new ArrayList<>();
    private List<ForumPost> posts = new LinkedList<>();

    public ForumUser(String userName, String realName) {
        this.userName = userName;
        this.realName = realName;
    }

    public List<ForumComment> getComments() {
        return comments;
    }

    public List<ForumPost> getPosts() {
        return posts;
    }

    public int getCommentsQuantity() {
        return comments.size();
    }
    public int getPostsQuantity() {
        return posts.size();
    }

    public String getUserName() {
        return userName;
    }

    public String getRealName() {
        return realName;
    }

    public void addComment(ForumComment comment) {
        this.comments.add(comment);
    }

    public void addComment(ForumPost forumPost, String commentBody, String author) {
        this.comments.add(new ForumComment(forumPost, commentBody, author));
    }

    public ForumComment getComment(int commentIndex) {
        if (commentIndex >= 0 && commentIndex < comments.size()) {
            return comments.get(commentIndex);
        }

        return null;
    }

    public void addPost(ForumPost forumPost) {
        this.posts.add(forumPost);
    }

    public void addPost(String postBody, String author) {
        this.posts.add(new ForumPost(postBody, author));
    }

    public ForumPost getPost(int postIndex) {
        if (postIndex >= 0 && postIndex < posts.size()) {
            return posts.get(postIndex);
        }

        return null;
    }

    public boolean removeComment(ForumComment comment) {
        if(this.comments.contains(comment)) {
            this.comments.remove(comment);
            return true;
        }

        return false;
    }

    public boolean removePost(ForumPost forumPost) {
        if(this.posts.contains(forumPost)) {
            this.posts.remove(forumPost);
            return true;
        }

        return false;
    }
}
