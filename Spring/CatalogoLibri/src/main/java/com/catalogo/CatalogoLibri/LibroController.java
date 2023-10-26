package com.catalogo.CatalogoLibri;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/libri")
public class LibroController {

	@Autowired
	private LibroService libroService;

	@GetMapping
	public Collection<Libro> listaLibri() {
		return libroService.ottieniTutti();
	}

	@GetMapping("/{id}")
	public Libro ottieniLibro(@PathVariable Long id) {
		return libroService.ottieniPerId(id);
	}

	@PostMapping
	public Libro nuovoLibro(@RequestBody Libro libro) {
		return libroService.aggiungiLibro(libro);
	}

	@PutMapping("/{id}")
	public Libro aggiornaLibro(@PathVariable Long id, @RequestBody Libro libro) {
		return libroService.aggiornaLibro(id, libro);
	}

	@DeleteMapping("/{id}")
	public void eliminaLibro(@PathVariable Long id) {
		libroService.eliminaLibro(id);
	}
}
