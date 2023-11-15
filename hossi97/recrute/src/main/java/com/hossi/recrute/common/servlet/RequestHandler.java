package com.hossi.recrute.common.servlet;

import com.hossi.recrute.common.auth.AuthData;
import com.hossi.recrute.common.auth.Authenticator;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Map;

public interface RequestHandler {
    boolean isAuth(HttpServletRequest request);
    Authenticator getAuthenticator(HttpServletRequest request);

    AuthData getAuthData(HttpServletRequest request);
    String getParameter(String key, HttpServletRequest request);
    String getJson(HttpServletRequest request) throws IOException;
    Map<String, Object> getSessionAll(HttpServletRequest request);
    Object getSession(String key, HttpServletRequest request);
    Cookie[] getCookies(HttpServletRequest request);
    void setAttribute(String key, Object value, HttpServletRequest request);
    void setSession(String key, Object value, HttpServletRequest request);
    void removeSession(String key, HttpServletRequest request);
}
