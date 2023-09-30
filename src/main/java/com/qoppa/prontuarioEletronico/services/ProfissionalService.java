package com.qoppa.prontuarioEletronico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qoppa.prontuarioEletronico.interfaces.IProfissionalService;
import com.qoppa.prontuarioEletronico.models.Profissional;
import com.qoppa.prontuarioEletronico.repository.IProfissionalRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProfissionalService implements IProfissionalService<Profissional> {

    private final IProfissionalRepository profissionalRepository;

    public ProfissionalService(IProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    @Override
    public List<Profissional> findAll() {
        return profissionalRepository.findAll();
    }

    @Override
    public Profissional findById(Long id) {
        Optional<Profissional> optionalProfissional = profissionalRepository.findById(id);
        return optionalProfissional.orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
    }

    @Override
    public Profissional save(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }

    @Override
    public void deleteById(Long id) {
        profissionalRepository.deleteById(id);
    }

}
