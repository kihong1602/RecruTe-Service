package com.blanc.recrute.common;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewResolver {

  public static String setPath(String viewName) {
    return "/WEB-INF/" + viewName + ".jsp";
  }

  public static void render(String path, HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher(setPath(path)).forward(request, response);
  }
}
