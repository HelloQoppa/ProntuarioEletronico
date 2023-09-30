package com.qoppa.prontuarioEletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qoppa.prontuarioEletronico.models.PrescricaoMedica;

public interface IPrescricaoMedicaRepository extends JpaRepository<PrescricaoMedica, Long> {

}
