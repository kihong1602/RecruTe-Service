package com.blanc.recrute.recruitment.dto;

public enum WorkForm {
  TW("비정규직", "Temporary Worker"),
  CW("계약직", "Contract Worker"),
  FTW("정규직", "Full Time Worker");

  private final String korDsc;
  private final String engDsc;

  WorkForm(String korDsc, String engDsc) {
    this.korDsc = korDsc;
    this.engDsc = engDsc;
  }

  public String getKorDsc() {
    return korDsc;
  }

  public String getEngDsc() {
    return engDsc;
  }
}
