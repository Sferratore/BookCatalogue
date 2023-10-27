package com.BiblioEx.EsercizioBiblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private MembroRepository membroRepository;

    public void aggiungiPrenotazione(Prenotazione prenotazione) {
        Libro libro = libroRepository.trovaLibroPerId(prenotazione.getLibroId());
        if (libro != null && libro.getQuantitaDisponibile() > 0) {
            prenotazioneRepository.aggiungiPrenotazione(prenotazione);
            libroRepository.decrementaQuantitaDisponibile(prenotazione.getLibroId());
            Membro membro = membroRepository.trovaMembroPerId(prenotazione.getMembroId());
            if (membro != null) {
                membro.getPrenotazioni().add(prenotazione);
                membroRepository.aggiornaMembro(membro);
            }
        }
    }

    public Collection<Prenotazione> tuttePrenotazioni() {
        return prenotazioneRepository.tuttePrenotazioni();
    }

    public Prenotazione trovaPrenotazionePerId(Long id) {
        return prenotazioneRepository.trovaPrenotazionePerId(id);
    }

    public void aggiornaPrenotazione(Prenotazione prenotazione) {
        prenotazioneRepository.aggiornaPrenotazione(prenotazione);
    }

    public void rimuoviPrenotazione(Long id) {
        prenotazioneRepository.rimuoviPrenotazione(id);
    }

}
