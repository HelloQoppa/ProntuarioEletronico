package com.qoppa.prontuarioEletronico.dto;

import java.util.List;

public record PrescricaoMedicaDTO(

        List<String> medicamentos,
        String dosagemMedicamento,
        String descricao) {

}
