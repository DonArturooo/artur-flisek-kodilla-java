package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

    static Library library = new Library("Main");

    @BeforeAll
    static void beforeAll() {
        Book[] books = {new Book("The Hobbit", "J.R.R. Tolkien", LocalDate.of(1937, 9, 21)), new Book("1984", "George Orwell", LocalDate.of(1949, 6, 8)), new Book("Brave New World", "Aldous Huxley",
                LocalDate.of(1932, 1, 1)), new Book("Dune", "Frank Herbert", LocalDate.of(1965, 8, 1)), new Book("To Kill a Mockingbird", "Harper Lee", LocalDate.of(1960, 7, 11))};
        for (Book book : books) {
            library.addBook(book);
        }
    }

    @Test
    void testGetBooks() {
        Library shallowCopy = null, deepCopy = null;
        try {
            shallowCopy = library.shallowCopy();
            shallowCopy.setName("Shallow Copy");
            deepCopy = library.deepCopy();
            deepCopy.setName("Deep Copy");
        } catch (CloneNotSupportedException e) {
            System.err.println(e.getMessage());
        }

        Book book = new Book("The Catcher in the Rye", "J.D. Salinger", LocalDate.of(1951, 7, 16));

        shallowCopy.addBook(book);

        Library finalShallowCopy = shallowCopy, finalDeepCopy = deepCopy;

        System.out.println("Shallow copy books: " + finalShallowCopy.getBooks());
        System.out.println("Deep copy books: " + finalDeepCopy.getBooks());
        System.out.println("Main books: " + library.getBooks());

        assertAll(
                () -> assertEquals(6, library.getBooks().size()),
                () -> assertEquals(6, finalShallowCopy.getBooks().size()),
                () -> assertNotEquals(6, finalDeepCopy.getBooks().size()),
                () -> assertEquals(5, finalDeepCopy.getBooks().size())
        );
    }
}
