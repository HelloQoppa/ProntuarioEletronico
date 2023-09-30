package com.qoppa.prontuarioEletronico.dto;

import java.util.List;

import com.qoppa.prontuarioEletronico.models.Paciente;

public record ProntuarioDTO(
        String historicoMedico,
        String anamnese,
        boolean alergias,
        Double altura,
        Double peso,
        List<String> medicamentosEmUso,
        String pressaoArterial,
        Double frequeciaCardiaca,
        Double frequeciaRespiratoria,
        Double temperatura,
        Double saturacao,
        Integer dor,
        String comobidades,
        String glicemiaCapilar,
        String evolucaoDeInfermagem,
        Paciente paciente

) {

}
