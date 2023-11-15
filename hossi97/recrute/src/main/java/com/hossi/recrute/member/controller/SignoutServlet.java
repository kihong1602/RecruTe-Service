package com.hossi.recrute.member.controller;

import com.hossi.recrute.common.auth.Authenticator;
import com.hossi.recrute.common.auth.processor.AuthManager;
import com.hossi.recrute.common.auth.util.AuthStream;
import com.hossi.recrute.common.service.anno.MBR;
import com.hossi.recrute.common.servlet.HttpController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@WebServlet(name = "signoutServlet", value = "/signout")
public class SignoutServlet extends HttpController {

    @Override @MBR(value = "103", description = "로그아웃")
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Authenticator authenticator = getAuthenticator(request);
        AuthManager.expireAuth(authenticator, new AuthStream(request, response));
        servletSetter()
            .setStatus(SC_OK, response)
            .sendRedirect("", response);
    }
}
