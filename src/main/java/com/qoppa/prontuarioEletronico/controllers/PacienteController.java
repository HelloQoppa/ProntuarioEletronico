package com.qoppa.prontuarioEletronico.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qoppa.prontuarioEletronico.dto.PacienteDTO;
import com.qoppa.prontuarioEletronico.models.Curso;
import com.qoppa.prontuarioEletronico.models.Endereco;
import com.qoppa.prontuarioEletronico.models.Paciente;
import com.qoppa.prontuarioEletronico.services.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> findAll() {
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public Paciente findById(@PathVariable Long id) {
        return pacienteService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Paciente save(@RequestBody @Validated PacienteDTO pacienteDTO) {

        Paciente paciente = new Paciente();

        paciente.setNomeDoPaciente(pacienteDTO.nomeDoPaciente());
        paciente.setTelefone(pacienteDTO.telefone());
        paciente.setEmail(pacienteDTO.email());
        paciente.setDataDeNascimento(pacienteDTO.dataDeNascimento());
        paciente.setEtinia(pacienteDTO.etinia());
        paciente.setNumeroDeMatricula(pacienteDTO.numeroDeMatricula());
    
        Curso curso = new Curso();
        curso.setNome(pacienteDTO.curso().nome());
        curso.setPeriodo(pacienteDTO.curso().periodo());
        paciente.setCurso(curso);
    
        Endereco endereco = new Endereco();
        endereco.setRua(pacienteDTO.endereco().rua());
        endereco.setCidade(pacienteDTO.endereco().cidade());
        endereco.setCep(pacienteDTO.endereco().cep());
        endereco.setEstado(pacienteDTO.endereco().estado());
        endereco.setPais(pacienteDTO.endereco().pais());
        paciente.setEndereco(endereco);
    
        return pacienteService.save(paciente);
    }

    @PutMapping
    @Transactional

    @ResponseStatus(code = HttpStatus.OK)
    public Paciente update(@PathVariable Long id, @RequestBody Paciente paciente) {
        return pacienteService.save(paciente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        pacienteService.deleteById(id);
    }

}
