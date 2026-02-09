package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest(){
        //Given
        Set<Book> books = Set.of(
                new Book("", "Book 1", 2010, ""),
                new Book("", "Book 2", 2012, ""),
                new Book("", "Book 3", 2015, ""),
                new Book("", "Book 4", 2018, ""),
                new Book("", "Book 5", 2020, "")
        );

        MedianAdapter adapter = new MedianAdapter();
        //When
        int result = adapter.publicationYearMedian(books);

        //Then
        assertEquals(2015, result);
    }

}
