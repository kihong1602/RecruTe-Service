package com.blanc.recrute.member.dto;

import com.blanc.recrute.common.Word;

public class InvalidDTO {

  private final String data;

  public InvalidDTO(Word data) {
    this.data = data.value();
  }

  @Override
  public String toString() {
    return "InvalidDTO{" +
        "data='" + data + '\'' +
        '}';
  }
}
