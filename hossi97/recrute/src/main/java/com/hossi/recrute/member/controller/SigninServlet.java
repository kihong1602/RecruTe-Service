package com.hossi.recrute.member.controller;

import com.hossi.recrute.common.auth.AuthData;
import com.hossi.recrute.common.auth.processor.AuthManager;
import com.hossi.recrute.common.auth.util.AuthStream;
import com.hossi.recrute.common.http.JsonManager;
import com.hossi.recrute.common.service.anno.MBR;
import com.hossi.recrute.common.service.message.ErrorMessage;
import com.hossi.recrute.common.service.message.MessageCreator;
import com.hossi.recrute.common.servlet.HttpController;
import com.hossi.recrute.common.servlet.ViewResolver;
import com.hossi.recrute.member.dto.request.SigninReqDto;
import com.hossi.recrute.member.dto.response.SigninResDto;
import com.hossi.recrute.member.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.google.common.net.MediaType.JSON_UTF_8;
import static com.hossi.recrute.common.auth.AuthType.COOKIE;
import static jakarta.servlet.http.HttpServletResponse.SC_OK;
import static jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

@WebServlet(name = "loginServlet", value = "/signin")
public class SigninServlet extends HttpController {
    private final MemberService memberService = new MemberService();

    @Override @MBR(value = "101", description = "로그인 페이지 조회")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        servletSetter()
            .setAttribute("mainViewPath", ViewResolver.resolveMainViewPath("signin"), request)
            .forward(ViewResolver.getMainViewPath(), request, response);
    }

    @Override @MBR(value = "102", description = "로그인")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SigninReqDto signinReqDto = JsonManager.fromJson(getJson(request), SigninReqDto.class);
        SigninResDto signinResDto = memberService.signin(signinReqDto);
        AuthData authData = new AuthData.Builder()
            .id(signinResDto.getId())
            .certification(signinResDto.getCertification())
            .build();
        if(authData.isPresent()) {
            AuthManager.grantAuth(COOKIE, authData, new AuthStream(request, response));
            servletSetter().setStatus(SC_OK, response);
        } else {
            ErrorMessage errorMessage = MessageCreator.createErrorMessage();
            servletSetter()
                .setStatus(SC_UNAUTHORIZED, response)
                .setJson(JSON_UTF_8, JsonManager.toJson(errorMessage), response);
        }
    }

}