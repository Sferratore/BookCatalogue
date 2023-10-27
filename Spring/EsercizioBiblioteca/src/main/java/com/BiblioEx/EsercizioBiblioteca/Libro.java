package com.BiblioEx.EsercizioBiblioteca;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Libro {
    private Long id;
    private String titolo;
    private String autore;
    private String genere;
    private int annoPubblicazione;
    private int quantitaDisponibile;
    private HashMap<Long, Prenotazione> prenotazioni;

    // Costruttore
    public Libro() {
        prenotazioni = new HashMap<>();
    }

    // Getter e setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getQuantitaDisponibile() {
        return quantitaDisponibile;
    }

    public void setQuantitaDisponibile(int quantitaDisponibile) {
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public HashMap<Long, Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(HashMap<Long, Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    @Override
    public String toString() {
        return "Libro [id=" + id + ", titolo=" + titolo + ", autore=" + autore + ", genere=" + genere
                + ", annoPubblicazione=" + annoPubblicazione + ", quantitaDisponibile=" + quantitaDisponibile
                + ", prenotazioni=" + prenotazioni + "]";
    }
}