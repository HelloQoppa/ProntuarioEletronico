package com.qoppa.prontuarioEletronico.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "healthProfessionals")
@Entity(name = "healthProfessionals")
@ToString
@Data
@Setter
@EqualsAndHashCode(callSuper = false)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Profissional extends Pessoa {

    private String especialidade;
    private String numeroRegistro;

}
