package com.qoppa.prontuarioEletronico.enums;

public enum EtiniaEnum {

    PRETO("preto"),
    PARDO("pardo"),
    BRANCO("branco"),
    IDIGENA("idigena");

    private String etinia;

    private EtiniaEnum(String etinia) {
        this.etinia = etinia;

    }

    public String getEtinia() {
        return etinia;
    }

}
