package com.BiblioEx.EsercizioBiblioteca;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;


public class Membro {
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private List<Prenotazione> prenotazioni;

    public Membro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    @Override
    public String toString() {
        return "Membro [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
                + ", prenotazioni=" + prenotazioni + "]";
    }
}