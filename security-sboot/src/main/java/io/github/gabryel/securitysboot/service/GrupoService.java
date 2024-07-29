package io.github.gabryel.securitysboot.service;

import io.github.gabryel.securitysboot.entity.Grupo;
import io.github.gabryel.securitysboot.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

}
