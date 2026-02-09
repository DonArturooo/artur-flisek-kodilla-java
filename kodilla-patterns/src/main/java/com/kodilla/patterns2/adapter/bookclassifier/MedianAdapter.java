package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {

        for (Book book : bookSet) {
            books.put(createBookSignature(book.getSignature()), createBook(book.getTitle(), book.getAuthor(), book.getPublicationYear()));
        }

        return medianPublicationYear(books);
    }
}
