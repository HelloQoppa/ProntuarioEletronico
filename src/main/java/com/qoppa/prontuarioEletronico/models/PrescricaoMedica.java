package com.qoppa.prontuarioEletronico.models;

import java.util.List;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "medicalPrescription")
@Entity(name = "medicalPrescription")
@ToString
@Data
@Setter
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PrescricaoMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private List<String> medicamentos;
    private String dosagemMedicamento;
    private String descricao;
}
