package com.br.gabryel.localizacao.repository;

import com.br.gabryel.localizacao.entity.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>, JpaSpecificationExecutor<Cidade> {

    /**
     * Finds a list of Cidade objects by their nome.
     *
     * @param  nome	the name to search for
     * @return         	a list of Cidade objects with the given name
     */
    List<Cidade> findByNome(String nome);

    @Query("select c from Cidade c where upper(c.nome) like upper(?1)")
    Page<Cidade> findByNomeLike(String nome, Pageable pageable);

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

    /**
     * Finds a list of Cidade objects by their populacao.
     *
     * @param  populacao  the populacao to search for
     * @return             a list of Cidade objects with the given populacao
     */
    List<Cidade> findByPopulacao(Long populacao);

    /**
     * Finds a list of Cidade objects with a population greater than the given population.
     *
     * @param  populacao  the population to compare against
     * @return             a list of Cidade objects with a population greater than the given population
     */
    List<Cidade> findByPopulacaoGreaterThan(Long populacao);

    /**
     * Finds a list of Cidade objects with a population less than the given population.
     *
     * @param  populacao  the population to compare against
     * @return             a list of Cidade objects with a population less than the given population
     */
    List<Cidade> findByPopulacaoLessThan(Long populacao);

    /**
     * Finds a list of Cidade objects with a population less than or equal to the given population.
     *
     * @param  populacao  the population to compare against
     * @return             a list of Cidade objects with a population less than or equal to the given population
     */
    List<Cidade> findByPopulacaoLessThanEqual(Long populacao);

    /**
     * Finds a list of Cidade objects with a population between the given minimum and maximum values.
     *
     * @param  populacaoMin  the minimum population value to search for
     * @param  populacaoMax  the maximum population value to search for
     * @return                a list of Cidade objects with a population between the given minimum and maximum values
     */
    List<Cidade> findByPopulacaoBetween(Long populacaoMin, Long populacaoMax);

}
