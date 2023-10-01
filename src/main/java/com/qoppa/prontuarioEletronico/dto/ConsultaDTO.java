package com.qoppa.prontuarioEletronico.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ConsultaDTO(
                @JsonFormat(pattern = "yyyy-MM-dd") LocalDate dataConsulta,
                String sintomas,
                String diagnostico,
                String prescricaoMedica,
                boolean statusConsulta,
                @JsonProperty("pacienteId") // Renomeia a propriedade JSON
                Long pacienteId

) {

}
