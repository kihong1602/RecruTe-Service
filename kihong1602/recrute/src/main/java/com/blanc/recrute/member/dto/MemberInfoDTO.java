package com.blanc.recrute.member.dto;

public class MemberInfoDTO {

  private String memberId;
  private String password;
  private String name;
  private String email;
  private Integer gender;
  private String birth;
  private String phoneNumber;

  public MemberInfoDTO(String memberId, String password, String name, String email, Integer gender,
      String birth, String phoneNumber) {
    this.memberId = memberId;
    this.password = password;
    this.name = name;
    this.email = email;
    this.gender = gender;
    this.birth = birth;
    this.phoneNumber = phoneNumber;
  }

  public String getMemberId() {
    return memberId;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public Integer getGender() {
    return gender;
  }

  public String getBirth() {
    return birth;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }
}
