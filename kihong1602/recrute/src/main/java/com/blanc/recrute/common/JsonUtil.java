package com.blanc.recrute.common;

import com.blanc.recrute.member.dto.ValidationDTO;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class JsonUtil {

  private JsonUtil() {
    throw new IllegalStateException("Utility class");
  }

  private static final ThreadLocal<Gson> gsonThreadLocal = ThreadLocal.withInitial(Gson::new);

  public static <T> T jsonParser(HttpServletRequest request, Class<T> className) throws IOException {
    BufferedReader requestReader = request.getReader();

    String bodyParsingJson = requestReader.lines().collect(Collectors.joining());
    return parsingJson(bodyParsingJson, className);
  }

  public static <T extends ValidationDTO> void sendJSON(HttpServletResponse response, T invalidDTO)
      throws IOException {
    String json = gsonThreadLocal.get().toJson(invalidDTO);

    response.setContentType("application/json");
    PrintWriter responseWriter = response.getWriter();
    responseWriter.write(json);
    responseWriter.close();

    gsonThreadLocal.remove();
  }

  private static <T> T parsingJson(String json, Class<T> className) {
    return gsonThreadLocal.get().fromJson(json, className);
  }
}
