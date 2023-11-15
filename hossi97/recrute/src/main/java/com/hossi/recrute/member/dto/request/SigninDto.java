package com.hossi.recrute.member.dto.request;

public class SigninDto {
    private final String memberId;
    private final String password;

    public String getMemberId() {
        return memberId;
    }
    public String getPassword() { return password; }

    public SigninDto(SigninDto.Builder builder) {
        this.memberId = builder.memberId;
        this.password = builder.password;
    }

    public static class Builder {
        private String memberId = null;
        private String password = null;

        public Builder() {
        }

        public SigninDto.Builder memberId(String val) {
            memberId = val;
            return this;    // 이렇게 하면 . 으로 체인을 이어갈 수 있다.
        }

        public SigninDto.Builder password(String val) {
            password = val;
            return this;
        }

        public SigninDto build() {
            return new SigninDto(this);
        }
    }
}
