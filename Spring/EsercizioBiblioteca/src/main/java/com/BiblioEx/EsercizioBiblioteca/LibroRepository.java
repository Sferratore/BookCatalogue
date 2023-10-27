package com.BiblioEx.EsercizioBiblioteca;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@Repository
public class LibroRepository {
    private final Map<Long, Libro> libri = new HashMap<>();
    private Long currentId = 1L;

    public void aggiungiLibro(Libro libro) {
        libro.setId(currentId++);
        libri.put(libro.getId(), libro);
    }

    public Collection<Libro> tuttiLibri() {
        return libri.values();
    }

    public Libro trovaLibroPerId(Long id) {
        return libri.get(id);
    }

    public void aggiornaLibro(Libro libro) {
        if (libri.containsKey(libro.getId())) {
            libri.put(libro.getId(), libro);
        }
    }
    
    public void decrementaQuantitaDisponibile(Long libroId) {
        Libro libro = libri.get(libroId);
        if (libro != null && libro.getQuantitaDisponibile() > 0) {
            libro.setQuantitaDisponibile(libro.getQuantitaDisponibile() - 1);
            libri.put(libro.getId(), libro);
        }
    }

    public void rimuoviLibro(Long id) {
        libri.remove(id);
    }
}