package com.hossi.recrute.common.controller;

import com.hossi.recrute.common.service.anno.CMN;
import com.hossi.recrute.common.servlet.HttpController;
import com.hossi.recrute.common.servlet.ViewResolver;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@WebServlet(name = "homeServlet", value = "")
public class HomeServlet extends HttpController {
    @Override @CMN(value = "001", description = "홈페이지 조회")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        servletSetter()
            .setAttribute("mainViewPath", ViewResolver.resolveMainViewPath("home"), request)
            .setStatus(SC_OK, response)
            .forward(ViewResolver.getMainViewPath(), request, response);
    }
}
