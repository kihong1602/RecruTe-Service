package com.blanc.recrute.member.dto;

public class EmailInfoDTO {

  private final String sendEmail = "team.recrute1602@gmail.com";
  private final String password = "qlhg mjfn oscq fbzo";
  private final String receiveEmail;

  public EmailInfoDTO(String receiveEmail) {
    this.receiveEmail = receiveEmail;
  }

  public String getSendEmail() {
    return sendEmail;
  }

  public String getPassword() {
    return password;
  }

  public String getReceiveEmail() {
    return receiveEmail;
  }

}
