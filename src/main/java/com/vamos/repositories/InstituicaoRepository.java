package com.vamos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vamos.domain.Instituicao;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Integer> {

}
