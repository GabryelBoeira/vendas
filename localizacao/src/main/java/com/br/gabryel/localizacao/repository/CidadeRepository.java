package com.br.gabryel.localizacao.repository;

import com.br.gabryel.localizacao.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    /**
     * Finds a list of Cidade objects by their nome.
     *
     * @param  nome	the name to search for
     * @return         	a list of Cidade objects with the given name
     */
    List<Cidade> findByNome(String nome);

    /**
     * Finds a list of Cidade objects by their nome starting with the given string.
     *
     * @param  nome     the string to search for in the nome field
     * @return          a list of Cidade objects with the given nome starting with the provided string
     */
    List<Cidade> findByNomeStartingWith(String nome);

    /**
     * Finds a list of Cidade objects by their nome ending with the given string.
     *
     * @param  nome     the string to search for in the nome field
     * @return          a list of Cidade objects with the given nome ending with the provided string
     */
    List<Cidade> findByNomeEndingWith(String nome);

    /**
     * Finds a list of Cidade objects by their nome containing the given string.
     *
     * @param  nome     the string to search for in the nome field
     * @return          a list of Cidade objects with the given nome containing the provided string
     */
    List<Cidade> findByNomeContaining(String nome);

    
}
