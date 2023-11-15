package com.hossi.recrute.common.service.code;

public enum ServicePrefix {
    CMN("공통 서비스"),
    MBR("회원 서비스"),
    RCT("채용 서비스"),
    EXM("시험 서비스");

    private final String decription;

    ServicePrefix(String decription) {
        this.decription = decription;
    }
}
