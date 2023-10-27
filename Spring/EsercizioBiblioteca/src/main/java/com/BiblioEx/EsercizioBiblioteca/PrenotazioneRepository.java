package com.BiblioEx.EsercizioBiblioteca;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@Repository
public class PrenotazioneRepository {
    private final Map<Long, Prenotazione> prenotazioni = new HashMap<>();
    private Long currentId = 1L;

    public void aggiungiPrenotazione(Prenotazione prenotazione) {
        prenotazione.setId(currentId++);
        prenotazioni.put(prenotazione.getId(), prenotazione);
    }

    public Collection<Prenotazione> tuttePrenotazioni() {
        return prenotazioni.values();
    }

    public Prenotazione trovaPrenotazionePerId(Long id) {
        return prenotazioni.get(id);
    }

    public void aggiornaPrenotazione(Prenotazione prenotazione) {
        if (prenotazioni.containsKey(prenotazione.getId())) {
            prenotazioni.put(prenotazione.getId(), prenotazione);
        }
    }

    public void rimuoviPrenotazione(Long id) {
        prenotazioni.remove(id);
    }
}