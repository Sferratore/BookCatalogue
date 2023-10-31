package com.BiblioEx.LibraryExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    // Get a list of all reservations
    @GetMapping
    public Collection<Reservation> listReservations() {
        return reservationService.getAllReservations();
    }

    // Get reservation details by ID
    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    // Create a new reservation
    @PostMapping
    public void createReservation(@RequestBody Reservation reservation) {
        reservationService.addReservation(reservation);
    }

    // Update an existing reservation by ID
    @PutMapping("/{id}")
    public void updateReservation(@RequestBody Reservation reservation) {
        reservationService.updateReservation(reservation);
    }

    // Delete a reservation by ID
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
    }
}
