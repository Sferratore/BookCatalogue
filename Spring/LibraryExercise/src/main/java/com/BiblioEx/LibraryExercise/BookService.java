package com.BiblioEx.LibraryExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// BookService is a Spring service class responsible for managing book-related operations.
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // Method to add a new book.
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    // Method to retrieve a collection of all books.
    public Collection<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    // Method to find a book by its ID.
    public Book findBookById(Long id) {
        return bookRepository.findBookById(id);
    }

    // Method to update book details.
    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    // Method to remove a book by its ID.
    public void removeBook(Long id) {
        bookRepository.removeBook(id);
    }

    // Method to decrement the available quantity of a book.
    public void decrementAvailableQuantity(Long bookId) {
        bookRepository.decrementAvailableQuantity(bookId);
    }

    // Method to increment the available quantity of a book.
    public void incrementAvailableQuantity(Long bookId) {
        Book book = bookRepository.findBookById(bookId);
        if (book != null) {
            book.setAvailableQuantity(book.getAvailableQuantity() + 1);
            bookRepository.updateBook(book);
        }
    }

    // Method to search for books by genre or author.
    public Collection<Book> searchBooksByGenreOrAuthor(String genre, String author) {
        Collection<Book> allBooks = bookRepository.getAllBooks();

        if (genre != null && author != null) {
            return allBooks.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre) && book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
        } else if (genre != null) {
            return allBooks.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
        } else if (author != null) {
            return allBooks.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
        } else {
            return allBooks;
        }
    }
}