package com.hossi.recrute.common;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.UUID;

public class Authenticater {
    private Cookie authCookie;
    public boolean isAuthenticated(HttpServletRequest request){
        findAuthCookie(request);

        return authCookie != null;
    }

    private void renewAuthCookie(Cookie cookie) {
        cookie.setMaxAge(3600);
        authCookie = cookie;
    }

    public Cookie expireAuthCookie() {
        authCookie.setMaxAge(0);
        return authCookie;
    }

    public void setAuthCookie(HttpServletRequest request, Integer id) {
        String uuid = String.valueOf(UUID.randomUUID());
        request.getSession().setAttribute(uuid, id);
        Cookie cookie = new Cookie("sid", uuid);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(3600);
        authCookie = cookie;
    }

    public Cookie getAuthCookie(HttpServletRequest request) {
        if(authCookie == null) {
            findAuthCookie(request);
        }
        return authCookie;
    }

    private void findAuthCookie(HttpServletRequest request) {
        for(Cookie cookie: request.getCookies()) {
            if(cookie.getName().equals("sid")) {
                renewAuthCookie(cookie);
            }
        }
    }
}
