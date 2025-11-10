package com.kodilla.testing.forum;

import java.util.Objects;

public class ForumComment {
    private String commentBody, author;
    private ForumPost forumPost;

    public ForumComment(ForumPost forumPost,String commentBody, String author) {
        this.author = author;
        this.forumPost = forumPost;
        this.commentBody = commentBody;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public String getAuthor() {
        return author;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ForumComment that = (ForumComment) o;
        return Objects.equals(commentBody, that.commentBody) && Objects.equals(author, that.author) && Objects.equals(forumPost, that.forumPost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentBody, author, forumPost);
    }
}
