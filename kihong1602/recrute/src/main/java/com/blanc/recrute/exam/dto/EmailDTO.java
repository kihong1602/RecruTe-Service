package com.blanc.recrute.exam.dto;

public class EmailDTO {

  private String email;
  private String companyName;

  public EmailDTO(String email, String companyName) {
    this.email = email;
    this.companyName = companyName;
  }

  public String getEmail() {
    return email;
  }

  public String getCompanyName() {
    return companyName;
  }
}
