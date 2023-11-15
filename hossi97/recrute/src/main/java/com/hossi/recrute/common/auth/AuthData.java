package com.hossi.recrute.common.auth;

import com.hossi.recrute.member.vo.Certification;

import static com.hossi.recrute.member.vo.Certification.CERTIFIED;
import static com.hossi.recrute.member.vo.Certification.NON_CERTIFIED;

public class AuthData {
    private final Integer id;
    private final Certification certification;

    public AuthData(Builder builder) {
        this.id = builder.id;
        this.certification = builder.certification;
    }

    public Integer getId() {
        return id;
    }

    public Certification getCertification() {
        return certification;
    }

    public boolean isPresent() {
        return id != null;
    }

    public static class Builder {
        private Integer id = null;
        private Certification certification = null;

        public Builder() {
        }

        public AuthData.Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public AuthData.Builder certification(Integer certification) {
            this.certification = (certification == 0) ? NON_CERTIFIED : CERTIFIED;
            return this;
        }

        public AuthData.Builder certification(Certification certification) {
            this.certification = certification;
            return this;
        }

        public AuthData build() {
            return new AuthData(this);
        }
    }
}
