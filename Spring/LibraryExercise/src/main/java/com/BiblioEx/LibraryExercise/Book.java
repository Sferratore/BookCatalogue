package com.BiblioEx.LibraryExercise;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

// Book class represents a book entity.
public class Book {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private int availableQuantity;
    private HashMap<Long, Reservation> reservations;

    // Constructor
    public Book() {
        reservations = new HashMap<>();
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public HashMap<Long, Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(HashMap<Long, Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre
                + ", publicationYear=" + publicationYear + ", availableQuantity=" + availableQuantity
                + ", reservations=" + reservations + "]";
    }
}
