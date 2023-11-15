package com.hossi.recrute.common.servlet;

import com.google.common.net.MediaType;
import com.google.gson.JsonElement;
import com.hossi.recrute.common.auth.AuthData;
import com.hossi.recrute.common.auth.Authenticator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class HttpController extends HttpServlet {
    private static final ServletHandler servletHandler = ServletHandler.getINSTANCE();

    protected static boolean isAuth(HttpServletRequest request) {
        return servletHandler.isAuth(request);
    }

    protected static Authenticator getAuthenticator(HttpServletRequest request) {
        return servletHandler.getAuthenticator(request);
    }

    protected static AuthData getAuthData(HttpServletRequest request) {
        return servletHandler.getAuthData(request);
    }

    protected static String getPath(HttpServletRequest request) {
        return servletHandler.getPath(request);
    }

    protected static String getParameter(String key, HttpServletRequest request) {
        return servletHandler.getParameter(key, request);
    }

    protected static Object getSession(String key, HttpServletRequest request) {
        return servletHandler.getSession(key, request);
    }

    protected static Map<String, Object> getSessionAll(HttpServletRequest request) {
        return servletHandler.getSessionAll(request);
    }

    protected static Cookie[] getCookies(HttpServletRequest request) {
        return servletHandler.getCookies(request);
    }

    protected static String getJson(HttpServletRequest request) throws IOException {
        return servletHandler.getJson(request);
    }

    protected Setter servletSetter() {
        return Setter.INSTANCE;
    }

    protected static class Setter {
        private static final Setter INSTANCE = new Setter();

        private Setter() {
        }

        public Setter setSession(String key, Object value, HttpServletRequest request) {
            servletHandler.setSession(key, value, request);
            return this;
        }

        public Setter removeSession(String key, HttpServletRequest request) {
            servletHandler.removeSession(key, request);
            return this;
        }

        public Setter setCookie(Cookie cookie, HttpServletResponse response) {
            servletHandler.setCookie(cookie, response);
            return this;
        }

        public Setter removeCookie(Cookie cookie, HttpServletResponse response) {
            servletHandler.removeCookie(cookie, response);
            return this;
        }

        public Setter setAttribute(String key, Object value, HttpServletRequest request) {
            servletHandler.setAttribute(key, value, request);
            return this;
        }

        public Setter setStatus(int status, HttpServletResponse response) {
            servletHandler.setStatus(status, response);
            return this;
        }

        public void setJson(MediaType mediaType, String json, HttpServletResponse response) throws IOException {
            servletHandler.setJson(mediaType, json, response);
        }

        public void setJson(MediaType mediaType, JsonElement json, HttpServletResponse response) throws IOException {
            servletHandler.setJson(mediaType, json, response);
        }

        public void sendRedirect(String path, HttpServletResponse response) throws IOException {
            servletHandler.sendRedirect(path, response);
        }

        public void forward(String path, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            servletHandler.forward(path, request, response);
        }

    }
}
