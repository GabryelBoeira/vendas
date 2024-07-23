package com.br.gabryel.localizacao.repository;

import com.br.gabryel.localizacao.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {




}
