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

import com.qoppa.prontuarioEletronico.models.PrescricaoMedica;
import com.qoppa.prontuarioEletronico.services.PrescricaoMedicaService;

@RestController
@RequestMapping("/prescricaoMedica")
public class PrescricaoMedicaController {

    private final PrescricaoMedicaService prescricaoMedicaService;

    public PrescricaoMedicaController(PrescricaoMedicaService prescricaoMedicaService) {
        this.prescricaoMedicaService = prescricaoMedicaService;
    }

    @GetMapping
    public List<PrescricaoMedica> findAll() {
        return prescricaoMedicaService.findAll();
    }

    @GetMapping("/{id}")
    public PrescricaoMedica findById(@PathVariable Long id) {
        return prescricaoMedicaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PrescricaoMedica save(@RequestBody PrescricaoMedica prescricaoMedica) {
        return prescricaoMedicaService.save(prescricaoMedica);
    }

    @PutMapping
    @Transactional
    @ResponseStatus(code = HttpStatus.OK)
    public PrescricaoMedica update(@PathVariable Long id, @RequestBody PrescricaoMedica prescricaoMedica) {
        return prescricaoMedicaService.save(prescricaoMedica);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        prescricaoMedicaService.deleteById(id);
    }
}
