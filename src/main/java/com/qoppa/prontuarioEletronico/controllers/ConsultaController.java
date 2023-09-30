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

import com.qoppa.prontuarioEletronico.models.Consulta;
import com.qoppa.prontuarioEletronico.services.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
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
    @ResponseStatus(code = HttpStatus.CREATED)
    public Consulta save(@RequestBody Consulta consulta) {
        return consultaService.save(consulta);
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
