package com.hossi.recrute.member.dto.response;

public class CheckDupResDto {
    private Boolean isDup;
    public CheckDupResDto(Boolean isDup) {
        this.isDup = isDup;
    }

    public Boolean getIsDup() {
        return isDup;
    }
}
