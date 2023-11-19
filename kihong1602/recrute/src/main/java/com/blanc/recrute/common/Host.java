package com.blanc.recrute.common;

public enum Host {

  GOOGLE("google"),
  NAVER("naver");
  private final String name;

  Host(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
