package com.qoppa.prontuarioEletronico.enums;

public enum EthnicityEnum {

    PRETO("preto"),
    PARDO("pardo"),
    BRANCO("branco"),
    IDIGENA("idigena");

    private String ethnicity;

    private EthnicityEnum(String ethnicity) {

    }

    public String getEthnicity() {
        return ethnicity;
    }

}
