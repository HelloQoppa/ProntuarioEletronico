package com.qoppa.prontuarioEletronico.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qoppa.prontuarioEletronico.dto.ConsultaDTO;
import com.qoppa.prontuarioEletronico.dto.ProntuarioDTO;
import com.qoppa.prontuarioEletronico.models.Consulta;
import com.qoppa.prontuarioEletronico.models.Paciente;
import com.qoppa.prontuarioEletronico.models.Prontuario;
import com.qoppa.prontuarioEletronico.services.PacienteService;
import com.qoppa.prontuarioEletronico.services.ProntuarioService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/prontuario")
public class ProntuarioController {

    private final ProntuarioService prontuarioService;
    private final PacienteService pacienteService;

    public ProntuarioController(ProntuarioService prontuarioService, PacienteService pacienteService) {
        this.prontuarioService = prontuarioService;
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Prontuario> findAll() {
        return prontuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Prontuario findById(@PathVariable Long id) {
        return prontuarioService.findById(id);
    }

    @PostMapping
    public Prontuario cadastrarProntuario(@RequestBody @Validated ProntuarioDTO prontuarioDTO,
            @RequestParam Long pacienteId) {
        // Busque o paciente com base no ID
        Optional<Paciente> pacienteOptional = pacienteService.findById(pacienteId);
        if (pacienteOptional.isPresent()) {
            Paciente paciente = pacienteOptional.get();

            Prontuario prontuario = new Prontuario();
            prontuario.setPaciente(paciente);
            prontuario.setHistoricoMedico(prontuarioDTO.historicoMedico());
            prontuario.setAlergias(prontuarioDTO.alergias());
            prontuario.setAltura(prontuarioDTO.altura());
            prontuario.setPeso(prontuarioDTO.peso());
            prontuario.setMedicamentosEmUso(prontuarioDTO.medicamentosEmUso());
            prontuario.setPressaoArterial(prontuarioDTO.pressaoArterial());
            prontuario.setFrequenciaCardiaca(prontuarioDTO.frequenciaCardiaca());
            prontuario.setFrequeciaRespiratoria(prontuarioDTO.frequeciaRespiratoria());
            prontuario.setTemperatura(prontuarioDTO.temperatura());
            prontuario.setSaturacao(prontuarioDTO.saturacao());
            prontuario.setDor(prontuarioDTO.dor());
            prontuario.setComorbidades(prontuarioDTO.comorbidades());
            prontuario.setGlicemiaCapilar(prontuarioDTO.glicemiaCapilar());
            prontuario.setEvolucaoDeInfermagem(prontuarioDTO.evolucaoDeInfermagem());

            // Salve a consulta no serviço de consulta
            return prontuarioService.save(prontuario);
        } else {
            throw new EntityNotFoundException("Paciente não encontrado");
        }
    }

    @PutMapping
    @Transactional
    @ResponseStatus(code = HttpStatus.OK)
    public Prontuario update(@PathVariable Long id, @RequestBody Prontuario paciente) {
        return prontuarioService.save(paciente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        prontuarioService.deleteById(id);
    }
}
