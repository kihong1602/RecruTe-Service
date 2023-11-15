package com.hossi.recrute.member.controller;

import com.hossi.recrute.common.Authenticater;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "signoutServlet", value = "/signout")
public class SignoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Authenticater authenticater = new Authenticater();
        depriveAuth(request, response, authenticater);
        response.setStatus(302);
        response.sendRedirect("/");
    }

    private static void depriveAuth(HttpServletRequest request, HttpServletResponse response, Authenticater authenticater) {
        if(authenticater.isAuthenticated(request)) {
            Cookie cookie = authenticater.expireAuthCookie();
            response.addCookie(cookie);
        }
    }

}
