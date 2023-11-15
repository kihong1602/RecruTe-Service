package com.hossi.recrute.member.dto.request;

import java.time.LocalDate;

public class SignupReqDto {
    private final Integer id;
    private final String username;
    private final String email;
    private final String name;
    private final Integer gender;
    private final String password;
    private final String passwordConfirm;
    private final String phoneNumber;
    private final LocalDate birth;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Integer getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate  getBirth() {
        return birth;
    }


    public SignupReqDto(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.email = builder.email;
        this.name = builder.name;
        this.gender = builder.gender;
        this.password = builder.password;
        this.passwordConfirm = builder.passwordConfirm;
        this.phoneNumber = builder.phoneNumber;
        this.birth = builder.birth;
    }

    public static class Builder {
        private Integer id = null;
        private String username = null;
        private String email = null;
        private String name = null;
        private Integer gender = null;
        private String password = null;
        private String passwordConfirm = null;
        private String phoneNumber = null;
        private LocalDate  birth = null;
        public Builder() {
        }

        public Builder username(String val) {
            username = val;
            return this;    // 이렇게 하면 . 으로 체인을 이어갈 수 있다.
        }
        public Builder email(String val) {
            email = val;
            return this;
        }
        public Builder name(String val) {
            name = val;
            return this;
        }
        public Builder gender(Integer val) {
            gender = val;
            return this;
        }
        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder passwordConfirm(String val) {
            passwordConfirm = val;
            return this;
        }

        public Builder phoneNumber(String val) {
            phoneNumber = val;
            return this;
        }

        public Builder birth(LocalDate val) {
            birth = val;
            return this;
        }

        public SignupReqDto build() {
            return new SignupReqDto(this);
        }
    }
}
