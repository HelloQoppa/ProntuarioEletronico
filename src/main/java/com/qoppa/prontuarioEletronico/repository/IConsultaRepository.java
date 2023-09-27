package com.qoppa.prontuarioEletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qoppa.prontuarioEletronico.models.Consulta;

public interface IConsultaRepository extends JpaRepository<Consulta, Long> {

}
