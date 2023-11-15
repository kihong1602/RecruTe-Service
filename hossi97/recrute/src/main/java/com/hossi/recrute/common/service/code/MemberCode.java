package com.hossi.recrute.common.service.code;

import java.util.HashMap;
import java.util.Map;

public enum MemberCode implements ServiceCode {
    MBR001("회원가입 페이지 조회"), MBR002("회원 등록"), MBR003("아이디 중복 조회"), MBR004("회원가입 완료 페이지 조회"),
    MBR101("로그인 페이지 조회"), MBR102("로그인"), MBR103("로그아웃"),
    MBR201("추가 권한 조회"),
    MBR301("인증 이메일 전송"), MBR302("이메일 인증");

    private final static Map<String, ServiceCode> codes = new HashMap<>();
    private final static ServicePrefix prefix = ServicePrefix.MBR;
    private final String description;

    MemberCode(String description) {
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
