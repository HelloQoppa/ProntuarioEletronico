package com.qoppa.prontuarioEletronico.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Table(name = "person")
@Entity(name = "person")
@ToString
@Data
@Setter
@EqualsAndHashCode(callSuper = false)
@Getter
@AllArgsConstructor
@NoArgsConstructor



public class Paciente extends Pessoa {

    private String numeroDeMatricula;
    
    @Embedded
    private Curso curso;
    
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Prontuario> prontuarios = new ArrayList<>();
    
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Consulta> consultas = new ArrayList<>();

}
