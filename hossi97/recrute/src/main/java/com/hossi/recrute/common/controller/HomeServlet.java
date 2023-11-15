package com.hossi.recrute.common.controller;

import com.hossi.recrute.common.ViewResolver;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "homeServlet", value = "")
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("mainViewPath", ViewResolver.resolveMainViewPath("home"));
        request.getRequestDispatcher(ViewResolver.getMainViewPath()).forward(request, response);
    }
}
