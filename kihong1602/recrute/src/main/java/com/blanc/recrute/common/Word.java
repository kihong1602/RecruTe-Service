package com.blanc.recrute.common;

public enum Word {
  SUCCESS("success"),
  FAIL("fail"),
  AVAILABLE("available"),
  UNAVAILABLE("unavailable"),
  BLANK("blank"),
  NONE("none"),
  EXIST("exist"),
  ERROR("error"),
  AUTH_KEY("authKey");

  private final String description;

  Word(String description) {
    this.description = description;
  }

  public String value() {
    return description;
  }

  public boolean equals(Word word) {
    return this.value().equals(word.value());
  }

}
