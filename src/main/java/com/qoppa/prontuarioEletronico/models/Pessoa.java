package com.qoppa.prontuarioEletronico.models;

import java.time.LocalDate;
import java.util.UUID;

import com.qoppa.prontuarioEletronico.enums.EtiniaEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@Setter
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass

public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name = "nome", insertable = false, updatable = false)
    private String nome;
    private String telefone;
    private String email;
    private LocalDate dataDeNascimento;
    @Embedded
    private Endereco endereco;
    @Enumerated(EnumType.STRING)
    private EtiniaEnum etinia;

}
