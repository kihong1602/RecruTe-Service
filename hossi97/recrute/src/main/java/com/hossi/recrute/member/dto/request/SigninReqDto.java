package com.hossi.recrute.member.dto.request;

public class SigninReqDto {
    private final String username;
    private final String password;

    public String getUsername() {
        return username;
    }
    public String getPassword() { return password; }

    public SigninReqDto(SigninReqDto.Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public static class Builder {
        private String username = null;
        private String password = null;

        public Builder() {
        }

        public SigninReqDto.Builder username(String val) {
            username = val;
            return this;
        }

        public SigninReqDto.Builder password(String val) {
            password = val;
            return this;
        }

        public SigninReqDto build() {
            return new SigninReqDto(this);
        }
    }
}
