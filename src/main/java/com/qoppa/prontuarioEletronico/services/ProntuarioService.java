package com.qoppa.prontuarioEletronico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qoppa.prontuarioEletronico.interfaces.IProntuarioService;
import com.qoppa.prontuarioEletronico.models.Prontuario;
import com.qoppa.prontuarioEletronico.repository.IProntuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProntuarioService implements IProntuarioService<Prontuario> {

    private final IProntuarioRepository prontuarioRepository;

    public ProntuarioService(IProntuarioRepository prontuarioRepository) {
        this.prontuarioRepository = prontuarioRepository;
    }

    @Override
    public List<Prontuario> findAll() {
        return prontuarioRepository.findAll();
    }

    @Override
    public Prontuario findById(Long id) {
        Optional<Prontuario> optionalProntuario = prontuarioRepository.findById(id);
        return optionalProntuario.orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
    }

    @Override
    public Prontuario save(Prontuario prontuario) {
        return prontuarioRepository.save(prontuario);
    }

    @Override
    public void deleteById(Long id) {
        prontuarioRepository.deleteById(id);
    }

}
