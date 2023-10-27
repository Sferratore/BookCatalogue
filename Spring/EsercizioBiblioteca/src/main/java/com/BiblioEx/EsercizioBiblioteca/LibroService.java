package com.BiblioEx.EsercizioBiblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public void aggiungiLibro(Libro libro) {
        libroRepository.aggiungiLibro(libro);
    }

    public Collection<Libro> tuttiLibri() {
        return libroRepository.tuttiLibri();
    }

    public Libro trovaLibroPerId(Long id) {
        return libroRepository.trovaLibroPerId(id);
    }

    public void aggiornaLibro(Libro libro) {
        libroRepository.aggiornaLibro(libro);
    }

    public void rimuoviLibro(Long id) {
        libroRepository.rimuoviLibro(id);
    }

    public void decrementaQuantitaDisponibile(Long libroId) {
        Libro libro = libroRepository.trovaLibroPerId(libroId);
        if (libro != null && libro.getQuantitaDisponibile() > 0) {
            libro.setQuantitaDisponibile(libro.getQuantitaDisponibile() - 1);
            libroRepository.aggiornaLibro(libro);
        }
    }

    public void incrementaQuantitaDisponibile(Long libroId) {
        Libro libro = libroRepository.trovaLibroPerId(libroId);
        if (libro != null) {
            libro.setQuantitaDisponibile(libro.getQuantitaDisponibile() + 1);
            libroRepository.aggiornaLibro(libro);
        }
    }
    
    public Collection<Libro> cercaLibriPerGenereOAutore(String genere, String autore) {
        Collection<Libro> tuttiLibri = libroRepository.tuttiLibri();

        if (genere != null && autore != null) {
            return tuttiLibri.stream()
                .filter(libro -> libro.getGenere().equalsIgnoreCase(genere) && libro.getAutore().equalsIgnoreCase(autore))
                .collect(Collectors.toList());
        } else if (genere != null) {
            return tuttiLibri.stream()
                .filter(libro -> libro.getGenere().equalsIgnoreCase(genere))
                .collect(Collectors.toList());
        } else if (autore != null) {
            return tuttiLibri.stream()
                .filter(libro -> libro.getAutore().equalsIgnoreCase(autore))
                .collect(Collectors.toList());
        } else {
            return tuttiLibri;
        }
    }
}