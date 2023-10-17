package com.qoppa.prontuarioEletronico.dto;

import java.util.List;

public record ProntuarioDTO(
        String historicoMedico,
        String anamnese,
        boolean alergias,
        Double altura,
        Double peso,
        List<String> medicamentosEmUso,
        String pressaoArterial,
        Double frequenciaCardiaca,
        Double frequeciaRespiratoria,
        Double temperatura,
        Double saturacao,
        Integer dor,
        String comorbidades,
        String glicemiaCapilar,
        String evolucaoDeInfermagem,
        Long pacienteId // Alterado para Long em vez de Paciente
) {

    public ProntuarioDTO {
        if (pacienteId == null) {
            throw new IllegalArgumentException("O ID do paciente não pode ser nulo");
        }
    }
}
