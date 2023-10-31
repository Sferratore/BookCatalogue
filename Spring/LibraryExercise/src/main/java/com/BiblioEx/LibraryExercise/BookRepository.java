package com.BiblioEx.LibraryExercise;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

// BookRepository is a Spring repository class responsible for managing book data.
@Repository
public class BookRepository {
    private final Map<Long, Book> books = new HashMap<>();
    private Long currentId = 1L;

    // Method to add a new book to the repository.
    public void addBook(Book book) {
        book.setId(currentId++);
        books.put(book.getId(), book);
    }

    // Method to retrieve a collection of all books from the repository.
    public Collection<Book> getAllBooks() {
        return books.values();
    }

    // Method to retrieve a specific book by its ID from the repository.
    public Book findBookById(Long id) {
        return books.get(id);
    }

    // Method to update an existing book in the repository.
    public void updateBook(Book book) {
        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
        }
    }

    // Method to decrement the available quantity of a book.
    public void decrementAvailableQuantity(Long bookId) {
        Book book = books.get(bookId);
        if (book != null && book.getAvailableQuantity() > 0) {
            book.setAvailableQuantity(book.getAvailableQuantity() - 1);
            books.put(book.getId(), book);
        }
    }

    // Method to remove a book by its ID from the repository.
    public void removeBook(Long id) {
        books.remove(id);
    }
}