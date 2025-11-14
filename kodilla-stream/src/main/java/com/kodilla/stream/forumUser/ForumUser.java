package com.kodilla.stream.forumUser;

import java.time.LocalDate;

public class ForumUser {
    final private int id;
    final private String username;
    final private char sex;
    final private LocalDate birthDate;
    final private int postsCount;

    public ForumUser(int id, String username, char sex, LocalDate birthDate, int postsCount) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postsCount = postsCount;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsCount() {
        return postsCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" + "id=" + id + ", username='" + username + '\'' + ", sex=" + sex + ", birthDate=" + birthDate + ", postsCount=" + postsCount + '}';
    }
}
