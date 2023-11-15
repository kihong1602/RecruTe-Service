package com.hossi.recrute.common.service.code;

import java.util.HashMap;
import java.util.Map;

public enum ExamCode implements ServiceCode {
    EXM001("시험 응시 이메일 전송"), EXM002("시험 권한 인증 페이지 조회"), EXM003("시험 권한 인증");

    private final static Map<String, ServiceCode> codes = new HashMap<>();
    private final static ServicePrefix prefix = ServicePrefix.EXM;
    private final String description;

     ExamCode(String description) {
         this.description = description;
     }

    public String getDescription() {
        return description;
    }

    static Map<String, ServiceCode> getCodes() {
        ServiceCode.mapCodes(prefix, codes);
        return codes;
    }

    static ServicePrefix getPrefix() {
        return prefix;
    }
}
