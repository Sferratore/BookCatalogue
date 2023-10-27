package com.BiblioEx.EsercizioBiblioteca;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@Repository
public class MembroRepository {
    private final Map<Long, Membro> membri = new HashMap<>();
    private Long currentId = 1L;

    public void aggiungiMembro(Membro membro) {
        membro.setId(currentId++);
        membri.put(membro.getId(), membro);
    }

    public Collection<Membro> tuttiMembri() {
        return membri.values();
    }

    public Membro trovaMembroPerId(Long id) {
        return membri.get(id);
    }

    public void aggiornaMembro(Membro membro) {
        if (membri.containsKey(membro.getId())) {
            membri.put(membro.getId(), membro);
        }
    }

    public void rimuoviMembro(Long id) {
        membri.remove(id);
    }
}