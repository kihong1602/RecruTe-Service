package com.blanc.recrute.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class JsonUtil {

  public static String jsonParsing(HttpServletRequest request) throws IOException {

    BufferedReader requestReader = request.getReader();

    return requestReader.lines().collect(Collectors.joining());
  }

  public static void sendJSON(HttpServletResponse response, String json) throws IOException {
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
    response.getWriter().close();
  }
}
