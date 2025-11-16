package com.kodilla.stream;


import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumUser.Forum;
import com.kodilla.stream.forumUser.ForumUser;
import com.kodilla.stream.person.People;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        People.getList()
              .stream()
              .map(String::toUpperCase)
              .filter(str -> str.length() > 11)
              .map(str -> str.substring(0, str.indexOf(' ') + 2) + ".")
              .filter(str -> str.charAt(0) == 'M')
              .forEach(System.out::println);


        BookDirectory theBookDirectory = new BookDirectory();

        List<Book> theResultListOfBooks = theBookDirectory.getList()
                                                          .stream()
                                                          .filter(book -> book.getYearOfPublication() > 2005)
                                                          .toList();

        theResultListOfBooks.forEach(System.out::println);

        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList()
                                                                .stream()
                                                                .filter(book -> book.getYearOfPublication() > 2005)
                                                                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet()
                           .stream()
                           .map(entry -> entry.getKey() + ":" + entry.getValue())
                           .forEach(System.out::println);

        String theResultStringOfBooks = theBookDirectory.getList()
                                                        .stream()
                                                        .filter(book -> book.getYearOfPublication() > 2005)
                                                        .map(Book::toString)
                                                        .collect(Collectors.joining(", \n", "<<", ">>"));
        System.out.println(theResultStringOfBooks);


        //Zadanie 7.3
        new Forum().getUsersList()
                   .stream()
                   .filter(forumUser -> forumUser.getSex() == 'M')
                   .filter(forumUser -> LocalDate.now()
                                                 .getYear() - forumUser.getBirthDate()
                                                                       .getYear() >= 20)
                   .filter(forumUser -> forumUser.getPostsCount() >= 1)
                   .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser))
                   .entrySet()
                   .forEach(System.out::println);

        System.out.println(backWord("Ewa"));
    }


    //Zadanie dodatkowe 7.6
    public static String backWord(String word) {
        StringBuilder result = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; i--) {
            result.append(word.charAt(i));
        }

        return result.toString();
    }
}
