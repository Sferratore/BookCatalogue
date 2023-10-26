package com.catalogo.CatalogoLibri;
import java.util.Objects;

public class Libro {

    private Long id;
    private String titolo;
    private String autore;
    private int annoPubblicazione;

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

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return annoPubblicazione == libro.annoPubblicazione &&
                Objects.equals(id, libro.id) &&
                Objects.equals(titolo, libro.titolo) &&
                Objects.equals(autore, libro.autore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titolo, autore, annoPubblicazione);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                '}';
    }
}
