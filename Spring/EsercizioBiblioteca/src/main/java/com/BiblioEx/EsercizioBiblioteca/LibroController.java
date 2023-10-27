package com.BiblioEx.EsercizioBiblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/libri")
public class LibroController {
	@Autowired
	private LibroService libroService;

	@GetMapping
	public Collection<Libro> elencoLibri() {
		return libroService.tuttiLibri();
	}

	@GetMapping("/{id}")
	public Libro dettaglioLibro(@PathVariable Long id) {
		return libroService.trovaLibroPerId(id);
	}

	@PostMapping
	public void aggiungiLibro(@RequestBody Libro libro) {
		libroService.aggiungiLibro(libro);
	}

	@PutMapping("/{id}")
	public void aggiornaLibro(@RequestBody Libro libro) {
		libroService.aggiornaLibro(libro);
	}

	@DeleteMapping("/{id}")
	public void eliminaLibro(@PathVariable Long id) {
		libroService.rimuoviLibro(id);
	}

	@GetMapping("/cerca")
	public Collection<Libro> cercaLibri(@RequestParam String genere, @RequestParam String autore) {
		return libroService.cercaLibriPerGenereOAutore(genere, autore);
		
	}
}