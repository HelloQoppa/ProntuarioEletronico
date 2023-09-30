package com.qoppa.prontuarioEletronico.dto;

import io.micrometer.common.lang.NonNull;

public record EnderecoDTO(
                @NonNull String rua,
                @NonNull String cidade,
                @NonNull String cep,
                @NonNull String estado,
                @NonNull String pais) {
}
