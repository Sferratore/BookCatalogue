package com.BiblioEx.EsercizioBiblioteca;

import java.time.LocalDate;

public class Prenotazione {
    private Long id;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private Long membroId; 
    private Long libroId; 

    public Prenotazione() {
    }

    public Prenotazione(Long id, LocalDate dataInizio, LocalDate dataFine, Long membroId, Long libroId) {
        this.id = id;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.membroId = membroId;
        this.libroId = libroId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public Long getMembroId() {
        return membroId;
    }

    public void setMembroId(Long membroId) {
        this.membroId = membroId;
    }

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    @Override
    public String toString() {
        return "Prenotazione [id=" + id + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine +
               ", membroId=" + membroId + ", libroId=" + libroId + "]";
    }
}
