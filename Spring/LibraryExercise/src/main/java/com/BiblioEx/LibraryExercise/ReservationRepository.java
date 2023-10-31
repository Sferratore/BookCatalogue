package com.BiblioEx.LibraryExercise;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@Repository
public class ReservationRepository {
    private final Map<Long, Reservation> reservations = new HashMap<>();
    private Long currentId = 1L;

    // Add a reservation to the repository
    public void addReservation(Reservation reservation) {
        reservation.setId(currentId++);
        reservations.put(reservation.getId(), reservation);
    }

    // Retrieve all reservations from the repository
    public Collection<Reservation> getAllReservations() {
        return reservations.values();
    }

    // Find a reservation by its ID
    public Reservation getReservationById(Long id) {
        return reservations.get(id);
    }

    // Update an existing reservation in the repository
    public void updateReservation(Reservation reservation) {
        if (reservations.containsKey(reservation.getId())) {
            reservations.put(reservation.getId(), reservation);
        }
    }

    // Remove a reservation from the repository by its ID
    public void deleteReservationById(Long id) {
        reservations.remove(id);
    }
}