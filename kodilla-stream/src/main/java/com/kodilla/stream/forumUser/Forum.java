package com.kodilla.stream.forumUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    final static List<ForumUser> users = new ArrayList<>();

    public Forum() {
        users.add(new ForumUser(1, "AdamK", 'M', LocalDate.of(1990, 3, 12), 15));
        users.add(new ForumUser(2, "EwaNowa", 'F', LocalDate.of(1995, 7, 5), 0));
        users.add(new ForumUser(3, "Marek89", 'M', LocalDate.of(1989, 11, 30), 42));
        users.add(new ForumUser(4, "Ania22", 'F', LocalDate.of(2000, 1, 8), 5));
        users.add(new ForumUser(5, "KamilPro", 'M', LocalDate.of(1998, 4, 21), 123));
        users.add(new ForumUser(6, "Basia", 'F', LocalDate.of(1992, 9, 14), 7));
        users.add(new ForumUser(7, "TomekX", 'M', LocalDate.of(1987, 6, 3), 0));
        users.add(new ForumUser(8, "JuliaG", 'F', LocalDate.of(2001, 12, 2), 31));
        users.add(new ForumUser(9, "Robert77", 'M', LocalDate.of(1977, 10, 19), 256));
        users.add(new ForumUser(10, "KasiaM", 'F', LocalDate.of(1999, 2, 27), 18));
    }

    public List<ForumUser> getUsersList() {
        return new ArrayList<>(users);
    }
}
