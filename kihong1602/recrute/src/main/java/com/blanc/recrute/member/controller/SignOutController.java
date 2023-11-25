package com.blanc.recrute.member.controller;

import com.blanc.recrute.common.Authenticater;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signout", value = "/signout")
public class SignOutController extends HttpServlet {

  private final Authenticater authenticater = new Authenticater();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    depriveAuth(request, response);
    response.setStatus(HttpServletResponse.SC_FOUND);
    response.sendRedirect("/");
  }

  private void depriveAuth(HttpServletRequest request, HttpServletResponse response) {
    if (authenticater.isAuthenticated(request)) {
      Cookie cookie = authenticater.expireAuthCookie();
      response.addCookie(cookie);
    }
  }
}
