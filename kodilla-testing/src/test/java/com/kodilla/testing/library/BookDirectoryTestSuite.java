package com.kodilla.testing.library;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    static List<Book> bookList  = new ArrayList<>();

    @Mock
    private static LibraryDatabase libraryDatabaseMock;


    @BeforeAll
    static void beforeAll() {
        bookList.add(new Book("Secrets of Alamo", "John Smith", 2008));
        bookList.add(new Book("Secretaries and Directors", "Dilbert Michigan", 2012));
        bookList.add(new Book("Secret life of programmers", "Steve Wolkowitz", 2016));
        bookList.add(new Book("Secrets of Java", "Ian Tenewitch", 2010));

        System.out.println("Book List: " + bookList.toString());
    }


    @Nested
    @DisplayName("Tests for list book with conditions")
    class TestListBooksWithCondition {
        @Test
        void testListBooksWithConditionsReturnList() {
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            when(libraryDatabaseMock.listBooksWithCondition("Secrets")).thenReturn(bookList);

            assertEquals(4, bookLibrary.listBooksWithCondition("Secrets").size());
        }

        @Test
        void testListBooksWithConditionMoreThan20() {
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(mockedBookList(15));
            when(libraryDatabaseMock.listBooksWithCondition("FortyBook")).thenReturn(mockedBookList(40));
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(mockedBookList(0));

            assertEquals(15, bookLibrary.listBooksWithCondition("Any title").size());
            assertEquals(0, bookLibrary.listBooksWithCondition("FortyBook").size());
            assertEquals(0, bookLibrary.listBooksWithCondition("ZeroBooks").size());
        }

        @Test
        void testListBooksWithConditionFragmentShorterThan3() {
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            assertEquals(0, bookLibrary.listBooksWithCondition("An").size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }
    }


    @Nested
    @DisplayName("Tests list books in Hands")
    class TestListBooksInHandsBooks {
        @Mock
        private LibraryDatabase libraryDatabaseMock;

        @Test
        void testListBooksInHandsBooksWhenUserDontHaveBooks() {
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser libraryUser = new LibraryUser("Artur", "Flisek", "94070171548");

            assertEquals(0, bookLibrary.listBooksInHandsOf(libraryUser).size());
        }

        @Test
        void testListBooksInHandsBooksWhenUserHaveBooks() {
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser libraryUser = new LibraryUser("Artur", "Flisek", "94070171548");

            when(libraryDatabaseMock.listBooksInHandsOf(any())).thenReturn(mockedBookList(5));
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(mockedBookList(2));

            assertEquals(1, bookLibrary.listBooksInHandsOf(libraryUser).size());
            assertEquals(5, bookLibrary.listBooksInHandsOf(new LibraryUser("Jan", "Nowak", "76052129529")).size());
        }
    }

    private List<Book> mockedBookList(int size) {
        List<Book> resultList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            resultList.add(new Book("Title " + i, "Author " + i, 1970 + i));
        }

        return resultList;
    }
}
