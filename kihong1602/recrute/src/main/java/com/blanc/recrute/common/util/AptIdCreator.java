package com.blanc.recrute.common.util;

import java.util.UUID;

public class AptIdCreator {

  private AptIdCreator() {
    throw new IllegalStateException("Utility class");
  }

  public static String createAptId() {

    return String.valueOf(UUID.randomUUID())
                 .replace("-", "")
                 .substring(0, 10);

  }
}
