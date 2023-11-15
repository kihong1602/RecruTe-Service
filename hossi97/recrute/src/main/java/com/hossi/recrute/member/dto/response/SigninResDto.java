package com.hossi.recrute.member.dto.response;

public class SigninResDto {
    private final Integer id;
    private final Integer certification;

    public SigninResDto(Integer id, Integer certification) {
        this.id = id;
        this.certification = certification;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCertification() {
        return certification;
    }
}
