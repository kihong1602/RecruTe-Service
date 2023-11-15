package com.hossi.recrute.member.vo;

public enum Gender {
    FEMALE("여성"), MALE("남성");

    private final String description;

    Gender(String description) {
        this.description = description;
    }
}
