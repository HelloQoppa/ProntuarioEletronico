package com.qoppa.prontuarioEletronico.models;

import java.util.List;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "medicalRecords")
@Entity(name = "medicalRecords")
@ToString
@Data
@Setter
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String historicoMedico;
    private String anamnese;
    private boolean alergias;
    private Double altura;
    private Double peso;
    private List<String> medicamentosEmUso;
    private String pressaoArterial;
    private Double frequeciaCardiaca;
    private Double frequeciaRespiratoria;
    private Double temperatura;
    private Double saturacao;
    private Integer dor;
    private String comobidades;
    private String glicemiaCapilar;
    private String evolucaoDeInfermagem;
    @ManyToOne
    @JoinColumn(name = "prontuarioPacienteId")
    private Paciente paciente;
}
