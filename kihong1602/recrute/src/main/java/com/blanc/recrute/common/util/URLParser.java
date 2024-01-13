package com.blanc.recrute.common.util;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class URLParser {

  private URLParser() {
    throw new IllegalStateException("Utility class");
  }

  public static Integer getLastURI(HttpServletRequest request) {

    return Arrays.stream(request.getRequestURI()
                                .split("/"))
                 .reduce((first, second) -> second)
                 .map(str -> {
                   try {
                     return Integer.parseInt(str);
                   } catch (NumberFormatException e) {
                     throw new NumberFormatException();
                   }
                 })
                 .orElse(null);
  }

}
