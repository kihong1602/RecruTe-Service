package com.hossi.recrute.recruitment.vo;

public enum ContractType {
    PRM("정규직"), CTR("계약직"), ITR("인턴");

    private final String description;

    ContractType(String description) {
        this.description = description;
    }
}
