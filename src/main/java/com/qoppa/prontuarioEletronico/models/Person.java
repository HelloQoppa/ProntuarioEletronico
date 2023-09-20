package com.qoppa.prontuarioEletronico.models;

import java.time.LocalDate;

import com.qoppa.prontuarioEletronico.enums.EthnicityEnum;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@MappedSuperclass
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person extends Users {
    

    private String name;
    private String phoneNumber;
    private String email;
    private LocalDate birth;
    private Address address;
    private EthnicityEnum ethnicity;
    
}
