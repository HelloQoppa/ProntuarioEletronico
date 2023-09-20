package com.qoppa.prontuarioEletronico.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "address")
@Entity(name = "address")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pacient extends Person{
    
    private String registrationNumber;
}
