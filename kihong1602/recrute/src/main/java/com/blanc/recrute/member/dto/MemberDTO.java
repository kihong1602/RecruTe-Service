package com.blanc.recrute.member.dto;

import java.time.LocalDate;

public class MemberDTO {
    private int id;
    private String memberId;
    private String password;
    private String name;
    private LocalDate birth;
    private int gender;
    private String phoneNumber;
    private String email;
    private int authStatus;

    public MemberDTO(int id, String memberId, String password, String name, LocalDate birth, int gender, String phoneNumber, String email, int authStatus) {
        this.id = id;
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.authStatus = authStatus;
    }

    public MemberDTO(Builder builder) {
        id = builder.id;
        memberId = builder.memberId;
        name = builder.name;
        email = builder.email;
        password = builder.password;
        birth = builder.birth;
        phoneNumber = builder.phoneNumber;
        gender = builder.gender;
        authStatus = builder.authStatus;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getGender() {
        return gender;
    }

    public int getAuthStatus() {
        return authStatus;
    }

    public static class Builder {
        private int id;
        private String memberId;
        private String email;
        private String password;
        private LocalDate birth;
        private String phoneNumber;
        private int gender;
        private String name;
        private int authStatus;

        public Builder() {
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder memberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder birth(LocalDate birth) {
            this.birth = birth;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder gender(int gender) {
            this.gender = gender;
            return this;
        }

        public Builder authStatus(int authStatus) {
            this.authStatus = authStatus;
            return this;
        }

        public MemberDTO build() {
            return new MemberDTO(this);
        }
    }
}
