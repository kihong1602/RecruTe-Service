package com.hossi.recrute.recruitment.dto;

import com.hossi.recrute.member.dto.request.SigninDto;

public class ApplicantDto {
    private final String aptId;
    private final Integer id;
    private final Integer rctId;

    public ApplicantDto(ApplicantDto.Builder builder) {
        this.aptId = builder.aptId;
        this.id = builder.id;
        this.rctId = builder.rctId;
    }

    public static class Builder {
        private String aptId = null;
        private Integer id = null;
        private Integer rctId = null;

        public Builder() {
        }

        public ApplicantDto.Builder aptId(String val) {
            aptId = val;
            return this;
        }

        public ApplicantDto.Builder id(Integer val) {
            id = val;
            return this;
        }

        public ApplicantDto.Builder rctId(Integer val) {
            rctId = val;
            return this;
        }

        public ApplicantDto build() {
            return new ApplicantDto(this);
        }
    }

    public Integer getRctId() {
        return rctId;
    }

    public Integer getId() {
        return id;
    }

    public String getAptId() {
        return aptId;
    }
}
