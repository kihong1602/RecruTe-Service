package com.hossi.recrute.member.dto.response;

public class SignupResDto {
    private final Integer id;
    private final Integer certification;
    public SignupResDto(Integer id, Integer certification) {
        this.id = id;
        this.certification = certification;
    }
    public Integer getId() {
        return id;
    }
    public Integer getCertification() { return certification; }
}
