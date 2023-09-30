package com.qoppa.prontuarioEletronico.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.qoppa.prontuarioEletronico.models.Prontuario;
import com.qoppa.prontuarioEletronico.services.ProntuarioService;

@RestController
@RequestMapping("prontuario")
public class ProntuarioController {

    private final ProntuarioService prontuarioService;

    public ProntuarioController(ProntuarioService prontuarioService) {
        this.prontuarioService = prontuarioService;
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
    @ResponseStatus(code = HttpStatus.CREATED)
    public Prontuario save(@RequestBody Prontuario prontuario) {
        return prontuarioService.save(prontuario);
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
