package com.blanc.recrute.member.controller;

import com.blanc.recrute.common.UserAuthenticator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signout", value = "/signout")
public class LogoutController extends HttpServlet {

  private final UserAuthenticator userAuthenticator = new UserAuthenticator();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    depriveAuth(request, response);
    response.setStatus(HttpServletResponse.SC_FOUND);
    response.sendRedirect("/");
  }

  private void depriveAuth(HttpServletRequest request, HttpServletResponse response) {
    if (userAuthenticator.isAuthenticated(request)) {
      Cookie cookie = userAuthenticator.expireAuthCookie(request);
      response.addCookie(cookie);
    }
  }
}
