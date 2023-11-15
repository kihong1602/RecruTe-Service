package com.blanc.recrute.common;

public enum Count {
  ZERO(0);

  private final int number;

  Count(int number) {
    this.number = number;
  }

  public int getNumber(){
    return number;
  }
}
