package com.blanc.recrute.common;

import com.blanc.recrute.member.dto.InvalidDTO;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class JsonUtil {

  private static final ThreadLocal<Gson> gsonThreadLocal = ThreadLocal.withInitial(Gson::new);

  public static <T> T JsonParser(HttpServletRequest request, Class<T> className) throws IOException {
    BufferedReader requestReader = request.getReader();

    String bodyParsingJson = requestReader.lines().collect(Collectors.joining());
    return parsingJson(bodyParsingJson, className);
  }

  public static <T extends InvalidDTO> void sendJSON(HttpServletResponse response, T invalidDTO)
      throws IOException {
    String json = gsonThreadLocal.get().toJson(invalidDTO);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
    response.getWriter().close();
  }

  private static <T> T parsingJson(String json, Class<T> className) {
    return gsonThreadLocal.get().fromJson(json, className);
  }
}
