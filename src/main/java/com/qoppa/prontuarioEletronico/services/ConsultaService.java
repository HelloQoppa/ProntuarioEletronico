package com.qoppa.prontuarioEletronico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.qoppa.prontuarioEletronico.interfaces.IConsultaService;
import com.qoppa.prontuarioEletronico.models.Consulta;
import com.qoppa.prontuarioEletronico.repository.IConsultaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ConsultaService implements IConsultaService<Consulta> {

    final IConsultaRepository consultaRepository;

    public ConsultaService(IConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    @Override
    public Consulta findById(Long id) {
        Optional<Consulta> optionalConsulta = consultaRepository.findById(id);
        return optionalConsulta.orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
    }

    @Override
    public Consulta save(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    public void deleteById(Long id) {
        consultaRepository.deleteById(id);
    }

}
