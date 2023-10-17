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
import com.qoppa.prontuarioEletronico.models.Consulta;
import com.qoppa.prontuarioEletronico.models.Paciente;
import com.qoppa.prontuarioEletronico.services.ConsultaService;
import com.qoppa.prontuarioEletronico.services.PacienteService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private final ConsultaService consultaService;
    private final PacienteService pacienteService;

    public ConsultaController(ConsultaService consultaService, PacienteService pacienteService) {
        this.consultaService = consultaService;
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Consulta> findAll() {
        return consultaService.findAll();
    }

    @GetMapping("/{id}")

    public Consulta findById(@PathVariable Long id) {
        return consultaService.findById(id);
    }

    @PostMapping
    public Consulta saveConsulta(@RequestBody ConsultaDTO consultaDTO, @RequestParam Long pacienteId) {
        // Busque o paciente com base no ID
        Optional<Paciente> pacienteOptional = pacienteService.findById(pacienteId);
        if (pacienteOptional.isPresent()) {
            Paciente paciente = pacienteOptional.get();

            // Crie a consulta e atribua o paciente
            Consulta consulta = new Consulta();
            consulta.setPaciente(paciente);
            consulta.setId(pacienteId);
            consulta.setStatusConsulta(true);
            consulta.setDataConsulta(consultaDTO.dataConsulta());
            consulta.setSintomas(consultaDTO.sintomas());
            consulta.setPrescricaoMedica(consultaDTO.prescricaoMedica());
            consulta.setDiagnostico(consultaDTO.diagnostico());

            // Salve a consulta no serviço de consulta
            return consultaService.save(consulta);
        } else {
            throw new EntityNotFoundException("Paciente não encontrado");
        }
    }

    @PutMapping
    @Transactional
    @ResponseStatus(code = HttpStatus.OK)
    public Consulta update(@PathVariable Long id, @RequestBody Consulta consulta) {
        return consultaService.save(consulta);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        consultaService.deleteById(id);
    }
}
