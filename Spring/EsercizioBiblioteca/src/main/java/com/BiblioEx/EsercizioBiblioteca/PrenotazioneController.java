package com.BiblioEx.EsercizioBiblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {
    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping
    public Collection<Prenotazione> elencoPrenotazioni() {
        return prenotazioneService.tuttePrenotazioni();
    }

    @GetMapping("/{id}")
    public Prenotazione dettaglioPrenotazione(@PathVariable Long id) {
        return prenotazioneService.trovaPrenotazionePerId(id);
    }

    @PostMapping
    public void aggiungiPrenotazione(@RequestBody Prenotazione prenotazione) {
        prenotazioneService.aggiungiPrenotazione(prenotazione);
    }

    @PutMapping("/{id}")
    public void aggiornaPrenotazione(@RequestBody Prenotazione prenotazione) {
        prenotazioneService.aggiornaPrenotazione(prenotazione);
    }

    @DeleteMapping("/{id}")
    public void eliminaPrenotazione(@PathVariable Long id) {
        prenotazioneService.rimuoviPrenotazione(id);
    }
}