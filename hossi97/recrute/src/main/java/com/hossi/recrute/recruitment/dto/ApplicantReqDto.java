package com.hossi.recrute.recruitment.dto;

public class ApplicantReqDto {
    private final Integer id;
    private final Integer rctId;
    private String aptId;

    public ApplicantReqDto(ApplicantReqDto.Builder builder) {
        this.id = builder.id;
        this.rctId = builder.rctId;
    }

    public void setAptId(String aptId) {
        this.aptId = aptId;
    }

    public static class Builder {
        private Integer id = null;
        private Integer rctId = null;

        public Builder() {
        }


        public ApplicantReqDto.Builder id(Integer val) {
            id = val;
            return this;
        }

        public ApplicantReqDto.Builder rctId(Integer val) {
            rctId = val;
            return this;
        }

        public ApplicantReqDto build() {
            return new ApplicantReqDto(this);
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
