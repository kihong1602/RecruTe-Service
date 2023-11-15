package com.blanc.recrute.common;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class URLParser {

  public static Integer getLastURI(HttpServletRequest request) {

    return Arrays.stream(request.getRequestURI().split("/")).reduce((first, second) -> second)
                 .map(str -> {
                   try {
                     return Integer.parseInt(str);
                   } catch (NumberFormatException e) {
                     return null;
                   }
                 }).orElse(null);
  }

}
