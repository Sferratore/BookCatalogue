package com.BiblioEx.EsercizioBiblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/membri")
public class MembroController {
	@Autowired
	private MembroService membroService;

	@GetMapping
	public Collection<Membro> elencoMembri() {
		return membroService.tuttiMembri();
	}

	@GetMapping("/{id}")
	public Membro dettaglioMembro(@PathVariable Long id) {
		return membroService.trovaMembroPerId(id);
	}

	@PostMapping
	public void aggiungiMembro(@RequestBody Membro membro) {
		membroService.aggiungiMembro(membro);
	}

	@PutMapping("/{id}")
	public void aggiornaMembro(@RequestBody Membro membro) {
		membroService.aggiornaMembro(membro);
	}

	@DeleteMapping("/{id}")
	public void eliminaMembro(@PathVariable Long id) {
		membroService.rimuoviMembro(id);
	}

	@GetMapping("/{id}/prenotazioni-attive")
	public List<Prenotazione> elencoPrenotazioniAttiveMembro(@PathVariable Long id) {
		return membroService.elencoPrenotazioniMembro(id);
	}
}