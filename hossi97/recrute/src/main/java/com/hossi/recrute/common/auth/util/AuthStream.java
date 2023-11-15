package com.hossi.recrute.common.auth.util;

import com.hossi.recrute.common.auth.AuthData;
import com.hossi.recrute.common.auth.Authenticator;
import com.hossi.recrute.common.auth.AuthType;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthStream {
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public AuthStream(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void addAuthCookieAndSession(AuthType authType, Authenticator authenticator, AuthData authData) {
        switch (authType) {
            case COOKIE -> {
                response.addCookie((Cookie) authenticator.get());
                request.getSession().setAttribute(authenticator.getValue(), authData);
            }
        }
    }

    public void setAuthCookie(AuthType authType, Authenticator authenticator) {
        switch (authType) {
            case COOKIE -> {
                response.addCookie((Cookie) authenticator.get());
            }
        }
    }

    public void setAuthSession(Authenticator authenticator, AuthData authData) {
        request.getSession().setAttribute(authenticator.getValue(), authData);
    }

    public void removeAuth(AuthType authType, Authenticator authenticator) {
        switch (authType) {
            case COOKIE -> {
                response.addCookie((Cookie) authenticator.get());
                request.getSession().removeAttribute(authenticator.getValue());
            }
        }
    }

    public Object getRequestData(AuthType authType) {
        return switch (authType) {
            case COOKIE -> request.getCookies();
            default -> null;
        };
    }

    public boolean checkSession(String key) {
        return request.getSession().getAttribute(key) != null;
    }

    public AuthData getAuthData(Authenticator authenticator) {
        return (AuthData) request.getSession().getAttribute(authenticator.getValue());
    }
}
