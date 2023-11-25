package com.blanc.recrute.member.dto;

import com.blanc.recrute.common.Word;

public class ValidationDTO {

  private final String data;

  public ValidationDTO(Word data) {
    this.data = data.value();
  }

  public String getData() {
    return data;
  }

  @Override
  public String toString() {
    return "InvalidDTO{" +
        "data='" + data + '\'' +
        '}';
  }
}
