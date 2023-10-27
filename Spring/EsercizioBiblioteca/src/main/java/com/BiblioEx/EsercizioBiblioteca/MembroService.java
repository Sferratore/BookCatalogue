package com.BiblioEx.EsercizioBiblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class MembroService {
    @Autowired
    private MembroRepository membroRepository;

    public void aggiungiMembro(Membro membro) {
        membroRepository.aggiungiMembro(membro);
    }

    public Collection<Membro> tuttiMembri() {
        return membroRepository.tuttiMembri();
    }

    public Membro trovaMembroPerId(Long id) {
        return membroRepository.trovaMembroPerId(id);
    }

    public void aggiornaMembro(Membro membro) {
        membroRepository.aggiornaMembro(membro);
    }

    public void rimuoviMembro(Long id) {
        membroRepository.rimuoviMembro(id);
    }

    public List<Prenotazione> elencoPrenotazioniMembro(Long membroId) {
        Membro membro = membroRepository.trovaMembroPerId(membroId);
        if (membro != null) {
            return membro.getPrenotazioni();
        }
        return null;
    }
}
