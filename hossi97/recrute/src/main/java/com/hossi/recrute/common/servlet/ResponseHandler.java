package com.hossi.recrute.common.servlet;

import com.google.common.net.MediaType;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ResponseHandler {
    void setStatus(int status, HttpServletResponse response);
    void setJson(MediaType mediaType, String json, HttpServletResponse response) throws IOException;
    void sendRedirect(String path, HttpServletResponse response) throws IOException;
    void setCookie(Cookie cookie, HttpServletResponse response);
    void removeCookie(Cookie cookie, HttpServletResponse response);
}

