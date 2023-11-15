package com.blanc.recrute.common;

public enum TimeUnit {
  HOUR(3600, "hour"),
  MINUTE(60, "minute"),
  SECOND(1, "second");

  private final int value;
  private final String description;

  TimeUnit(int value, String description) {
    this.value = value;
    this.description = description;
  }

  public int getValue() {
    return value;
  }

  public String getDescription() {
    return description;
  }
}
