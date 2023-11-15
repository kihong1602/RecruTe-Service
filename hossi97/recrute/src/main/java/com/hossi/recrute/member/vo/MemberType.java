package com.hossi.recrute.member.vo;

public enum MemberType {
    NA("비회원"), GA("일반회원"), CA("기업회원");

    private final String description;

    MemberType(String description) {
        this.description = description;
    }
}
