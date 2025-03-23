package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {

    private final List<Book> books = new ArrayList<>(
            List.of(
                    new Book(1L, "First Book", "Alice"),
                    new Book(2L, "Second Book", "Bob")
            )
    );

    public Optional<Book> findById(long id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book save(Book book) {
        books.add(book);
        return book;
    }
}
