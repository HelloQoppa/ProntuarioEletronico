package com.qoppa.prontuarioEletronico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qoppa.prontuarioEletronico.models.Paciente;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findById(Long id);

}
