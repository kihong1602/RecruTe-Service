package com.hossi.recrute.recruitment.vo;

public enum CareerType {
    NWB("신입"), EXP("경력");

    private final String description;

    CareerType(String description) {
        this.description = description;
    }
}
