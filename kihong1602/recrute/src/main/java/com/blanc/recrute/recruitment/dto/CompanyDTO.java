package com.blanc.recrute.recruitment.dto;

//미사용시 삭제 예정
public class CompanyDTO {
    private final Integer id;
    private final String companyName;

    public CompanyDTO(Builder builder) {
        this.id = builder.id;
        this.companyName = builder.companyName;
    }

    public CompanyDTO(Integer id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    public Integer getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public static class Builder {
        private Integer id;
        private String companyName;

        public Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public CompanyDTO build() {
            return new CompanyDTO(this);
        }
    }

}
