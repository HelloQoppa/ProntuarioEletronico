package com.qoppa.prontuarioEletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qoppa.prontuarioEletronico.models.Pessoa;

public interface IPessoaRepository extends JpaRepository<Pessoa, Long> {

}
