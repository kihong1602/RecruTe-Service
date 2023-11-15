package com.blanc.recrute.common;

public enum Career {
  NEW("신입", "newbie"),
  EXP("경력자", "experience");

  private final String engDsc;
  private final String korDsc;

  Career(String korDsc, String engDsc) {
    this.korDsc = korDsc;
    this.engDsc = engDsc;
  }

  public String getKor() {
    return korDsc;
  }

  public String getEng() {
    return engDsc;
  }
}
