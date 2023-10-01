package com.qoppa.prontuarioEletronico.dto;

import java.time.LocalDate;
import java.util.List;

import com.qoppa.prontuarioEletronico.enums.EtiniaEnum;

public record PacienteDTO(

        String nomeDoPaciente,
        String telefone,
        String email,
        LocalDate dataDeNascimento,
        EtiniaEnum etinia,
        String numeroDeMatricula,
        EnderecoDTO endereco,
        CursoDTO curso,
        List<ConsultaDTO> consultas,
        List<ProntuarioDTO> prontuarios

) {

}
