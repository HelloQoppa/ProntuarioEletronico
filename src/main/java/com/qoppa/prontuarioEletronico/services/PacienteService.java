package com.qoppa.prontuarioEletronico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qoppa.prontuarioEletronico.interfaces.IPacienteService;
import com.qoppa.prontuarioEletronico.models.Paciente;
import com.qoppa.prontuarioEletronico.repository.IPacienteRepository;


@Service
public class PacienteService implements IPacienteService<Paciente> {

    final IPacienteRepository pacienteRepository;

    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void deleteById(Long id) {
        pacienteRepository.deleteById(id);
    }

}
