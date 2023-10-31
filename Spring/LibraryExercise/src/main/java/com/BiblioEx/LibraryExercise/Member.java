package com.BiblioEx.LibraryExercise;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

// Member class represents a library member entity.
public class Member {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Reservation> reservations;

    // Constructor
    public Member() {
    }

    // Getter and setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", reservations=" + reservations + "]";
    }
}