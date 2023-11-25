package com.blanc.recrute.common;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.util.UUID;

public class UserAuthenticator {

  private Cookie authCookie;


  public boolean isAuthenticated(HttpServletRequest request) {
    if (request.getCookies() != null) {
      for (Cookie cookie : request.getCookies()) {
        if (cookie != null && cookie.getName()
                                    .equals("sid")) {
          renewAuthCookie(cookie);
          return true;
        }
      }

    }
    return false;
  }

  private void renewAuthCookie(Cookie cookie) {
    cookie.setMaxAge(TimeUnit.HOUR.getValue());
    authCookie = cookie;
  }

  public Cookie expireAuthCookie() {
    authCookie.setMaxAge(Count.ZERO.getNumber());
    return authCookie;
  }

  public void setAuthCookie(HttpServletRequest request, String id) {
    String uuid = String.valueOf(UUID.randomUUID());
    Cookie cookie = new Cookie("sid", uuid);
    request.getSession()
           .setAttribute(uuid, id);
    cookie.setHttpOnly(true);
    cookie.setMaxAge(TimeUnit.HOUR.getValue());
    authCookie = cookie;
  }

  public Cookie getAuthCookie() {
    return authCookie;
  }
}
