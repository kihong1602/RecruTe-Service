package com.hossi.recrute.common.servlet;

import com.google.common.net.MediaType;
import com.google.gson.JsonElement;
import com.hossi.recrute.common.auth.AuthData;
import com.hossi.recrute.common.auth.Authenticator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ServletHandler implements RequestHandler, ResponseHandler, ViewHandler {
    private static final ServletHandler INSTANCE = new ServletHandler();

    private ServletHandler() {
    }

    public static ServletHandler getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public boolean isAuth(HttpServletRequest request) {
        return (boolean) request.getAttribute("isAuth");
    }

    @Override
    public Authenticator getAuthenticator(HttpServletRequest request) {
        return (Authenticator) request.getAttribute("authenticator");
    }

    @Override
    public AuthData getAuthData(HttpServletRequest request) {
        return (AuthData) request.getAttribute("authData");
    }

    public String getPath(HttpServletRequest request) {
        return request.getPathInfo();
    }

    @Override
    public String getParameter(String key, HttpServletRequest request) {
        return request.getParameter(key);
    }

    @Override
    public Object getSession(String key, HttpServletRequest request) {
        return request.getSession().getAttribute(key);
    }

    @Override
    public Map<String, Object> getSessionAll(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        Map<String, Object> map = new HashMap<>();
        httpSession.getAttributeNames().asIterator().forEachRemaining(key -> {
            map.put(key, httpSession.getAttribute(key));
        });
        return map;
    }

    @Override
    public Cookie[] getCookies(HttpServletRequest request) {
        return request.getCookies();
    }

    @Override
    public String getJson(HttpServletRequest request) throws IOException {
        return request.getReader().lines().collect(Collectors.joining());
    }

    @Override
    public void setSession(String key, Object value, HttpServletRequest request) {
        request.getSession().setAttribute(key, value);
    }

    @Override
    public void removeSession(String key, HttpServletRequest request) {
        request.getSession().removeAttribute(key);
    }

    @Override
    public void setCookie(Cookie cookie, HttpServletResponse response) {
        response.addCookie(cookie);
    }

    @Override
    public void removeCookie(Cookie cookie, HttpServletResponse response) {
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    @Override
    public void setAttribute(String key, Object value, HttpServletRequest request) {
        request.getSession().setAttribute(key, value);
    }

    @Override
    public void setJson(MediaType mediaType, String json, HttpServletResponse response) throws IOException {
        response.setContentType(mediaType.toString());
        response.setContentLength(json.length());
        response.getWriter().write(json);
    }


    public ServletHandler setJson(MediaType mediaType, JsonElement json, HttpServletResponse response) throws IOException {
        response.setContentType(mediaType.toString());
        response.getWriter().write(json.toString());
        return this;
    }


    @Override
    public void setStatus(int status, HttpServletResponse response) {
        response.setStatus(status);
    }

    @Override
    public void sendRedirect(String path, HttpServletResponse response) throws IOException {
        response.sendRedirect(path);
    }

    @Override
    public void forward(String path, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(path).forward(request, response);
    }
}
