package com.blanc.recrute.common;

import java.util.UUID;

public class AptIdFactory {

  private AptIdFactory() {
    throw new IllegalStateException("Utility class");
  }

  public static String createAptId() {

    return String.valueOf(UUID.randomUUID())
                 .replace("-", "")
                 .substring(0, 10);

  }
}
