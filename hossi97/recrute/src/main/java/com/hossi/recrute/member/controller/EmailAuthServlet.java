package com.hossi.recrute.member.controller;

import com.google.common.net.MediaType;
import com.hossi.recrute.common.auth.AuthData;
import com.hossi.recrute.common.http.JsonManager;
import com.hossi.recrute.common.mybatis.ResultType;
import com.hossi.recrute.common.service.anno.MBR;
import com.hossi.recrute.common.service.message.ErrorMessage;
import com.hossi.recrute.common.service.message.Message;
import com.hossi.recrute.common.service.message.MessageCreator;
import com.hossi.recrute.common.servlet.HttpController;
import com.hossi.recrute.member.service.EmailService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

import static com.google.common.net.MediaType.JSON_UTF_8;
import static com.hossi.recrute.common.mybatis.ResultType.SUCCESS;
import static jakarta.servlet.http.HttpServletResponse.SC_OK;
import static jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

@WebServlet(name = "signupCompleteServlet", value = "/member/email")
public class EmailAuthServlet extends HttpController {
    private final EmailService emailService = new EmailService();

    @Override @MBR(value = "301", description = "인증 이메일 전송")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AuthData authData = getAuthData(request);
        String code = String.valueOf(UUID.randomUUID());
        servletSetter().setSession(code, authData.getId(), request);
        ResultType result = emailService.sendEmail(authData.getId(), code);
        if(result == SUCCESS) {
            Message<String> message = MessageCreator.create();
            servletSetter()
                .setStatus(SC_OK, response)
                .setJson(MediaType.JSON_UTF_8, JsonManager.toJson(message), response);
        } else {
            ErrorMessage errorMessage = MessageCreator.createErrorMessage();
            servletSetter()
                .setStatus(SC_UNAUTHORIZED, response)
                .setJson(JSON_UTF_8, JsonManager.toJson(errorMessage), response);
        }
    }

}
