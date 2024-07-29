package io.github.gabryel.securitysboot.service;

import io.github.gabryel.securitysboot.entity.Grupo;
import io.github.gabryel.securitysboot.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepository grupoRepository;

    @Transactional
    public Grupo save(Grupo grupo) {
         return grupoRepository.save(grupo);
    }

    public List<Grupo> findAll() {
        return grupoRepository.findAll();
    }

    /**
     * Finds a Grupo by its nome.
     *
     * @param  nome	the nome of the Grupo to search for
     * @return			an Optional containing the Grupo if found, or empty if not found
     */
    public Optional<Grupo> findByNome(String nome) {
        return grupoRepository.findByNome(nome);
    }
}
