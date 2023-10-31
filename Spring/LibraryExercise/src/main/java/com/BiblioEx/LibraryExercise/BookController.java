package com.BiblioEx.LibraryExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

// LibroController is a Spring controller class responsible for handling HTTP requests related to books.
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    // Handle HTTP GET requests to retrieve a list of books.
    @GetMapping
    public Collection<Book> listBooks() {
        return bookService.getAllBooks();
    }

    // Handle HTTP GET requests to retrieve book details by ID.
    @GetMapping("/{id}")
    public Book getBookDetails(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    // Handle HTTP POST requests to add a new book.
    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    // Handle HTTP PUT requests to update book details.
    @PutMapping("/{id}")
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    // Handle HTTP DELETE requests to remove a book by ID.
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.removeBook(id);
    }

    // Handle HTTP GET requests to search for books by genre or author.
    @GetMapping("/search")
    public Collection<Book> searchBooks(@RequestParam String genre, @RequestParam String author) {
        return bookService.searchBooksByGenreOrAuthor(genre, author);
    }
}
