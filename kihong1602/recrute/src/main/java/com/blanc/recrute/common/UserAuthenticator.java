package com.blanc.recrute.common;

import static com.blanc.recrute.common.TimeUnit.HOUR;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.UUID;

public class UserAuthenticator {

  private Cookie authCookie;


  public boolean isAuthenticated(HttpServletRequest request) {

    return Arrays.stream(request.getCookies())
                 .filter(cookie -> cookie != null && cookie.getName()
                                                           .equals("sid"))
                 .peek(this::renewAuthCookie)
                 .findFirst()
                 .isPresent();
  }

  private void renewAuthCookie(Cookie cookie) {
    cookie.setMaxAge(HOUR.getValue());
    authCookie = cookie;
  }

  public Cookie expireAuthCookie(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.removeAttribute(authCookie.getValue());
    authCookie.setMaxAge(Count.ZERO.getNumber());
    return authCookie;
  }

  public void setAuthCookie(HttpServletRequest request, String id) {
    String uuid = String.valueOf(UUID.randomUUID());
    Cookie cookie = new Cookie("sid", uuid);
    HttpSession session = request.getSession();
    session.setAttribute(uuid, id);
    cookie.setHttpOnly(true);
    cookie.setMaxAge(HOUR.getValue());
    authCookie = cookie;
  }

  public Cookie getAuthCookie() {
    return authCookie;
  }
}
