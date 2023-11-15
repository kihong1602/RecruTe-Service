package com.hossi.recrute.member.controller;

import com.hossi.recrute.common.service.anno.MBR;
import com.hossi.recrute.common.servlet.HttpController;
import com.hossi.recrute.common.servlet.ViewResolver;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@WebServlet(name="signupServlet", value="/signup/complete")
public class SignupCompletServlet extends HttpController {
    @Override @MBR(value = "004", description = "회원가입 완료 페이지 조회")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        servletSetter()
            .setAttribute("mainViewPath", ViewResolver.resolveMainViewPath("signup-complete"), request)
            .setStatus(SC_OK, response)
            .forward(ViewResolver.getMainViewPath(), request, response);
    }

}
