package com.blanc.recrute.recruitment.dto;

//미사용시 삭제 예정
public class RctDetDTO {
    private final Integer id;
    private final String content;
    private final Integer recruitId;

    public RctDetDTO(Builder builder) {
        this.id = builder.id;
        this.content = builder.content;
        this.recruitId = builder.recruitId;
    }

    public RctDetDTO(Integer id, String content, Integer recruitId) {
        this.id = id;
        this.content = content;
        this.recruitId = recruitId;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Integer getRecruitId() {
        return recruitId;
    }

    public static class Builder {
        private Integer id;
        private String content;
        private Integer recruitId;

        public Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder recruitId(Integer recruitId) {
            this.recruitId = recruitId;
            return this;
        }

        public RctDetDTO build() {
            return new RctDetDTO(this);
        }
    }
}
