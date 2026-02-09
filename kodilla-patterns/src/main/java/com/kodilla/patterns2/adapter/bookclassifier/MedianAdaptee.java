package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookStatistics;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.Statistics;

import java.util.HashMap;
import java.util.Map;

public class MedianAdaptee implements BookStatistics {
    private static final Statistics statistics = new Statistics();
    protected Map<BookSignature, Book> books = new HashMap<>();

    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        return statistics.averagePublicationYear(books);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        return statistics.medianPublicationYear(books);
    }

    protected Book createBook(String title, String author, int publicationYear) {
        return new Book(title, author, publicationYear);
    }

    protected BookSignature createBookSignature(String signature) {
        return new BookSignature(signature);
    }
}
