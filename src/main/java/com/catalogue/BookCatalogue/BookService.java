package com.catalogue.BookCatalogue;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

@Service
public class BookService {

    private final Map<Long, Book> books = new HashMap<>();
    private Long currentId = 1L;

    // Method to add a book
    public Book addBook(Book book) {
        book.setId(currentId++);
        books.put(book.getId(), book);
        return book;
    }

    // Method to get all books
    public Collection<Book> getAll() {
        return books.values();
    }

    // Method to get a specific book by ID
    public Book getById(Long id) {
        return books.get(id);
    }

    // Method to update a book
    public Book updateBook(Long id, Book book) {
        if (books.containsKey(id)) {
            book.setId(id);
            books.put(id, book);
            return book;
        }
        return null;  // or you could throw an exception.
    }

    // Method to delete a book
    public void deleteBook(Long id) {
        books.remove(id);
    }
}
