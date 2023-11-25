package com.blanc.recrute.exam.dto;

public class ApplicantUserInfo {

  private String email;
  private String AptId;

  public ApplicantUserInfo(String email, String aptId) {
    this.email = email;
    AptId = aptId;
  }

  public String getEmail() {
    return email;
  }

  public String getAptId() {
    return AptId;
  }
}
