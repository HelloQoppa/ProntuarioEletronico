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

import com.qoppa.prontuarioEletronico.dto.ProfissinalDTO;
import com.qoppa.prontuarioEletronico.models.Endereco;
import com.qoppa.prontuarioEletronico.models.Profissional;
import com.qoppa.prontuarioEletronico.services.ProfissionalService;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService) {
        this.profissionalService = profissionalService;
    }

    @GetMapping
    public List<Profissional> findAll() {
        return profissionalService.findAll();
    }

    @GetMapping("/{id}")
    public Profissional findById(@PathVariable Long id) {
        return profissionalService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Profissional save(@RequestBody @Validated ProfissinalDTO profissionalDTO, Profissional profissional) {

        
        profissional.setNomeDoProfissional(profissionalDTO.nomeDoProfissional());
        profissional.setTelefone(profissionalDTO.telefone());
        profissional.setEmail(profissionalDTO.email());
        profissional.setDataDeNascimento(profissionalDTO.dataDeNascimento());
        profissional.setEtinia(profissionalDTO.etinia());
        profissional.setEspecialidade(profissionalDTO.especialidade());
        profissional.setNumeroRegistro(profissionalDTO.numeroRegistro());

        Endereco endereco = new Endereco();

        endereco.setRua(profissionalDTO.endereco().rua());
        endereco.setCidade(profissionalDTO.endereco().cidade());
        endereco.setCep(profissionalDTO.endereco().cep());
        endereco.setEstado(profissionalDTO.endereco().estado());
        endereco.setPais(profissionalDTO.endereco().pais());
        profissional.setEndereco(endereco);

        // Salve o profissional e retorne
        return profissionalService.save(profissional);
    }

    @PutMapping
    @Transactional
    @ResponseStatus(code = HttpStatus.OK)
    public Profissional update(@PathVariable Long id, @RequestBody Profissional profissional) {
        return profissionalService.save(profissional);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        profissionalService.deleteById(id);
    }

}
