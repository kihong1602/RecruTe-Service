package com.hossi.recrute.common.controller;

import com.google.gson.Gson;
import com.hossi.recrute.common.Authenticater;
import com.hossi.recrute.common.ErrorCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "authServlet", value = "/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Authenticater authenticater = new Authenticater();
        if(authenticater.isAuthenticated(request)) {
            ErrorCode errorCode = new ErrorCode("RCT-02", "Authenticated");
            String json = new Gson().toJson(errorCode);
            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write(json);
        } else {
            ErrorCode errorCode = new ErrorCode("RCT-02", "not Authenticated");
            String json = new Gson().toJson(errorCode);
            response.setStatus(401);
            response.setContentType("application/json");
            response.getWriter().write(json);
        }
    }
}