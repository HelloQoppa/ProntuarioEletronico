package com.qoppa.prontuarioEletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qoppa.prontuarioEletronico.models.Prontuario;

public interface IProntuarioRepository extends JpaRepository<Prontuario, Long> {

}
