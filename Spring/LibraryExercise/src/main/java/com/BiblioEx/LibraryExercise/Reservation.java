package com.BiblioEx.LibraryExercise;

import java.time.LocalDate;

//Reservation class represents a reservation entity.
public class Reservation {
 private Long id;
 private LocalDate startDate;
 private LocalDate endDate;
 private Long memberId;
 private Long bookId;

 // Default constructor
 public Reservation() {
 }

 // Parameterized constructor
 public Reservation(Long id, LocalDate startDate, LocalDate endDate, Long memberId, Long bookId) {
     this.id = id;
     this.startDate = startDate;
     this.endDate = endDate;
     this.memberId = memberId;
     this.bookId = bookId;
 }

 // Getter and setter methods

 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public LocalDate getStartDate() {
     return startDate;
 }

 public void setStartDate(LocalDate startDate) {
     this.startDate = startDate;
 }

 public LocalDate getEndDate() {
     return endDate;
 }

 public void setEndDate(LocalDate endDate) {
     this.endDate = endDate;
 }

 public Long getMemberId() {
     return memberId;
 }

 public void setMemberId(Long memberId) {
     this.memberId = memberId;
 }

 public Long getBookId() {
     return bookId;
 }

 public void setBookId(Long bookId) {
     this.bookId = bookId;
 }

 @Override
 public String toString() {
     return "Reservation [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate +
            ", memberId=" + memberId + ", bookId=" + bookId + "]";
 }
}
