package com.qoppa.prontuarioEletronico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qoppa.prontuarioEletronico.interfaces.IPrescricaoMedicaService;
import com.qoppa.prontuarioEletronico.models.PrescricaoMedica;
import com.qoppa.prontuarioEletronico.repository.IPrescricaoMedicaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PrescricaoMedicaService implements IPrescricaoMedicaService<PrescricaoMedica> {

    private final IPrescricaoMedicaRepository prescricaoMedicaRepository;

    public PrescricaoMedicaService(IPrescricaoMedicaRepository prescricaoMedicaRepository) {
        this.prescricaoMedicaRepository = prescricaoMedicaRepository;
    }

    @Override
    public List<PrescricaoMedica> findAll() {
        return prescricaoMedicaRepository.findAll();
    }

    @Override
    public PrescricaoMedica findById(Long id) {
        Optional<PrescricaoMedica> optionalPrescricaoMedica = prescricaoMedicaRepository.findById(id);
        return optionalPrescricaoMedica.orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
    }

    @Override
    public PrescricaoMedica save(PrescricaoMedica prescricaoMedica) {
        return prescricaoMedicaRepository.save(prescricaoMedica);
    }

    @Override
    public void deleteById(Long id) {
        prescricaoMedicaRepository.deleteById(id);
    }

}
