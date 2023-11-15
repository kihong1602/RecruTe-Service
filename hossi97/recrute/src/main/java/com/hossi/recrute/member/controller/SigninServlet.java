package com.hossi.recrute.member.controller;

import java.io.*;

import com.google.gson.Gson;
import com.hossi.recrute.common.ViewResolver;
import com.hossi.recrute.common.Authenticater;
import com.hossi.recrute.common.ErrorCode;
import com.hossi.recrute.member.dto.request.SigninDto;
import com.hossi.recrute.member.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/signin")
public class SigninServlet extends HttpServlet {
    private final MemberService memberService = new MemberService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("mainViewPath", ViewResolver.resolveMainViewPath("signin"));
        request.getRequestDispatcher(ViewResolver.getMainViewPath()).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Authenticater authenticater = new Authenticater();
        if(authenticater.isAuthenticated(request)) {
            Cookie renewedAuthCookie = authenticater.getAuthCookie(request);
            response.addCookie(renewedAuthCookie);
            response.setStatus(302);
            response.sendRedirect("/");
        } else {
            BufferedReader requestReader = request.getReader();
            SigninDto signinDto = null;
            while(requestReader.ready()) {
                signinDto = new Gson().fromJson(requestReader.readLine(), SigninDto.class);
            }

            Integer id = memberService.signin(signinDto);
            if(id != null) {
                authenticater.setAuthCookie(request, id);
                Cookie authCookie = authenticater.getAuthCookie(request);
                response.addCookie(authCookie);
                response.setStatus(302);
                response.sendRedirect("/");
            } else {
                ErrorCode error = new ErrorCode("USR-04", "Invalid ID/PW");
                String errorJSON = new Gson().toJson(error);
                response.setStatus(400);
                response.setContentType("application/json");
                response.setContentLength(errorJSON.length());
                response.getWriter().write(errorJSON);
            }
        }
    }
}