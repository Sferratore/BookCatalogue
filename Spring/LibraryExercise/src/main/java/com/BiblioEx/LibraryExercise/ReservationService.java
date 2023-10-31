package com.BiblioEx.LibraryExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    // Add a reservation and update associated book and member data
    public void addReservation(Reservation reservation) {
        Book book = bookRepository.findBookById(reservation.getBookId());
        if (book != null && book.getAvailableQuantity() > 0) {
            reservationRepository.addReservation(reservation);
            bookRepository.decrementAvailableQuantity(reservation.getBookId());
            Member member = memberRepository.findMemberById(reservation.getMemberId());
            if (member != null) {
                member.getReservations().add(reservation);
                memberRepository.updateMember(member);
            }
        }
    }

    // Retrieve all reservations
    public Collection<Reservation> getAllReservations() {
        return reservationRepository.getAllReservations();
    }

    // Find a reservation by its ID
    public Reservation getReservationById(Long id) {
        return reservationRepository.getReservationById(id);
    }

    // Update an existing reservation
    public void updateReservation(Reservation reservation) {
        reservationRepository.updateReservation(reservation);
    }

    // Remove a reservation by its ID
    public void deleteReservationById(Long id) {
        reservationRepository.deleteReservationById(id);
    }
}
