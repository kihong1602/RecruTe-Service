package com.hossi.recrute.member.vo;

public enum Certification {
    CERTIFIED("인증"), NON_CERTIFIED("미인증");

    private final String description;

    Certification(String description) {
        this.description = description;
    }
}
