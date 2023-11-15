package com.blanc.recrute.recruitment.dto;

public class ApplyDTO {

    private final Integer id;
    private final String aptId;
    private final Integer memberId;
    private final Integer recruitId;

    public ApplyDTO(Builder builder) {
        this.id = builder.id;
        this.aptId = builder.aptId;
        this.memberId = builder.memberId;
        this.recruitId = builder.recruitId;
    }

    public ApplyDTO(Integer id, String aptId, Integer memberId, Integer recruitId) {
        this.id = id;
        this.aptId = aptId;
        this.memberId = memberId;
        this.recruitId = recruitId;
    }

    public Integer getId() {
        return id;
    }

    public String getAptId() {
        return aptId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public Integer getRecruitId() {
        return recruitId;
    }

    public static class Builder {
        private Integer id;
        private String aptId;
        private Integer memberId;
        private Integer recruitId;

        public Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder aptId(String aptId) {
            this.aptId = aptId;
            return this;
        }

        public Builder memberId(Integer memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder recruitId(Integer recruitId) {
            this.recruitId = recruitId;
            return this;
        }

        public ApplyDTO build() {
            return new ApplyDTO(this);
        }
    }
}
