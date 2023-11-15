package com.juju.common;

import java.util.Random;

public class MakeRandomCode {
  public static String randomCharacter(int range) {
    StringBuilder sb = new StringBuilder();
    Random rd = new Random();

    for (int i = 0; i < range; i++) {
      sb.append((char) (rd.nextInt(26) + 65));
    }

    return sb.toString();
  }

  public static String randomNum(int range) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < range; i++) {
      sb.append((int) (Math.random() * 10));
    }

    return sb.toString();
  }
}
