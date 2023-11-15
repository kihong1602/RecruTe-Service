package com.hossi.recrute.common.service.code;

import java.util.HashMap;
import java.util.Map;

public enum CommonCode implements ServiceCode {
    CMN001("홈페이지 조회");

    private final static Map<String, ServiceCode> codes = new HashMap<>();
    private final static ServicePrefix prefix = ServicePrefix.CMN;
    private final String description;

    CommonCode(String description) {
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
