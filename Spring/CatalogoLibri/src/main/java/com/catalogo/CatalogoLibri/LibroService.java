package com.catalogo.CatalogoLibri;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

@Service 
public class LibroService {

    private final Map<Long, Libro> libri = new HashMap<>();
    private Long currentId = 1L;

    // Metodo per aggiungere un libropublic 
    Libro aggiungiLibro(Libro libro) {
        libro.setId(currentId++);
        libri.put(libro.getId(), libro);
        return libro;
    }

    // Metodo per ottenere tutti i libri
    public Collection<Libro> ottieniTutti() {
        return libri.values();
    }

    // Metodo per ottenere un libro specifico
    public Libro ottieniPerId(Long id) {
        return libri.get(id);
    }

    // Metodo per aggiornare un libro
    public Libro aggiornaLibro(Long id, Libro libro) {
        if (libri.containsKey(id)) {
            libro.setId(id);
            libri.put(id, libro);
            return libro;
        }
        return null;  // o potresti lanciare un'eccezione.
    }

    // Metodo per eliminare un libro
    public void eliminaLibro(Long id) {
        libri.remove(id);
    }
}
