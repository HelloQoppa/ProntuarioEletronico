package com.qoppa.prontuarioEletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qoppa.prontuarioEletronico.models.Profissional;

public interface IProfissionalRepository extends JpaRepository<Profissional, Long> {

}
