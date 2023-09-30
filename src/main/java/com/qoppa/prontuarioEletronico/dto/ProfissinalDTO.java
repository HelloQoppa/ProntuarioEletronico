package com.qoppa.prontuarioEletronico.dto;

import java.time.LocalDate;

import com.qoppa.prontuarioEletronico.enums.EtiniaEnum;

import io.micrometer.common.lang.NonNull;

public record ProfissinalDTO(

        @NonNull String nomeDoProfissional,
        @NonNull String telefone,
        @NonNull String email,
        @NonNull LocalDate dataDeNascimento,
        @NonNull EtiniaEnum etinia,
        @NonNull String especialidade,
        @NonNull String numeroRegistro,
        @NonNull EnderecoDTO endereco

) {

}
