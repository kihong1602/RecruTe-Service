package com.hossi.recrute.member.controller;

import com.hossi.recrute.common.auth.AuthData;
import com.hossi.recrute.common.auth.Authenticator;
import com.hossi.recrute.common.auth.processor.AuthManager;
import com.hossi.recrute.common.auth.util.AuthStream;
import com.hossi.recrute.common.http.JsonManager;
import com.hossi.recrute.common.mybatis.ResultType;
import com.hossi.recrute.common.service.anno.MBR;
import com.hossi.recrute.common.service.message.ErrorMessage;
import com.hossi.recrute.common.service.message.MessageCreator;
import com.hossi.recrute.common.servlet.HttpController;
import com.hossi.recrute.common.servlet.ViewResolver;
import com.hossi.recrute.member.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.google.common.net.MediaType.JSON_UTF_8;
import static com.hossi.recrute.common.mybatis.ResultType.SUCCESS;
import static com.hossi.recrute.member.vo.Certification.CERTIFIED;
import static jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

@WebServlet(name = "emailServlet", value = "/member/email/auth")
public class EmailAuthProcessServlet extends HttpController {
    private final MemberService memberService = new MemberService();

    @Override @MBR(value = "302", description = "이메일 인증")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = getParameter("code", request);
        Integer id = getId(getSession(code, request));
        if(id == null) {
            servletSetter()
                .removeSession(code, request)
                .setStatus(200, response)
                .setAttribute("mainViewPath", ViewResolver.resolveMainViewPath("email-auth-not-complete"), request)
                .forward(ViewResolver.getMainViewPath(), request, response);
        } else {
            ResultType result = memberService.authMail(id);
            if(result == SUCCESS) {
                Authenticator authenticator = getAuthenticator(request);
                AuthData authData = new AuthData.Builder()
                    .id(id)
                    .certification(CERTIFIED)
                    .build();
                AuthManager.changeAuthData(authenticator, authData, new AuthStream(request, response));
                servletSetter()
                    .removeSession(code, request)
                    .setStatus(200, response)
                    .setAttribute("mainViewPath", ViewResolver.resolveMainViewPath("email-auth-complete"), request)
                    .forward(ViewResolver.getMainViewPath(), request, response);
            } else {
                ErrorMessage errorMessage = MessageCreator.createErrorMessage();
                servletSetter()
                    .setStatus(SC_UNAUTHORIZED, response)
                    .setJson(JSON_UTF_8, JsonManager.toJson(errorMessage), response);
            }
        }
    }

    private Integer getId(Object id) {
        return (id != null) ? (Integer) id : null;
    }

}
