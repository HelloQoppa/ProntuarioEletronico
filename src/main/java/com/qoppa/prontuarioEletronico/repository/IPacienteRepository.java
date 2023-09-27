package com.qoppa.prontuarioEletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qoppa.prontuarioEletronico.models.Paciente;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

}
