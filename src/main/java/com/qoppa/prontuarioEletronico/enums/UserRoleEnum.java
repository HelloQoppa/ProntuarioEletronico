package com.qoppa.prontuarioEletronico.enums;

public enum UserRoleEnum {

    USER("user"),
    ADMIN("admin");

    private String role;

    private UserRoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
