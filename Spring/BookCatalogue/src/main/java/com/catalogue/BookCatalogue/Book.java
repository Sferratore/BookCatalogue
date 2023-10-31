package com.catalogue.BookCatalogue;
import java.util.Objects;

public class Book {

    private Long id;
    private String title;
    private String author;
    private int publicationYear;

    // Getter for the book's ID
    public Long getId() {
        return id;
    }

    // Setter for the book's ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the book's title
    public String getTitle() {
        return title;
    }

    // Setter for the book's title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for the book's author
    public String getAuthor() {
        return author;
    }

    // Setter for the book's author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter for the book's publication year
    public int getPublicationYear() {
        return publicationYear;
    }

    // Setter for the book's publication year
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    // Method to compare if two books are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publicationYear == book.publicationYear &&
                Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    // Method to generate a hash code based on the book's attributes
    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, publicationYear);
    }

    // Method to get a textual representation of the book
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
