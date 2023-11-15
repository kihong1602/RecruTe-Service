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
import com.hossi.recrute.member.dto.request.SignupReqDto;
import com.hossi.recrute.member.dto.response.SignupResDto;
import com.hossi.recrute.member.service.MemberService;
import com.hossi.recrute.member.vo.Gender;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

import static com.google.common.net.MediaType.JSON_UTF_8;
import static com.hossi.recrute.common.auth.AuthType.COOKIE;
import static jakarta.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@WebServlet(name="signupServlet", value="/signup")
public class SignupServlet extends HttpController {
    private final MemberService memberService = new MemberService();

    @Override @MBR(value = "001", description = "회원가입 페이지 조회")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        servletSetter()
            .setAttribute("mainViewPath", ViewResolver.resolveMainViewPath("signup"), request)
            .setStatus(SC_OK, response)
            .forward(ViewResolver.getMainViewPath(), request, response);
    }

    @Override @MBR(value = "002", description = "회원 등록")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        SignupReqDto signupReqDto = getSignupReqDto(request);
        SignupResDto signupResDto = memberService.signup(signupReqDto);
        AuthData authData = new AuthData.Builder()
            .id(signupResDto.getId())
            .certification(signupResDto.getCertification())
            .build();
        if(authData.isPresent()) {
            AuthManager.grantAuth(COOKIE, authData, new AuthStream(request, response));
            servletSetter()
                .setStatus(SC_OK, response)
                .sendRedirect("/signup/complete", response);
        } else {
            ErrorMessage errorMessage = MessageCreator.createErrorMessage();
            servletSetter()
                .setStatus(SC_BAD_REQUEST, response)
                .setJson(JSON_UTF_8, JsonManager.toJson(errorMessage), response);
        }
    }

    private SignupReqDto getSignupReqDto(HttpServletRequest request) {
        Integer gender = parseGender(getParameter("gender", request));
        LocalDate birth = parseBirth(getParameter("birth", request));

        return new SignupReqDto.Builder()
            .username(getParameter("id", request))
            .email(getParameter("email", request))
            .name(getParameter("name", request))
            .gender(gender)
            .password(getParameter("password", request))
            .passwordConfirm(getParameter("passwordConfirm", request))
            .phoneNumber(getParameter("phoneNumber", request))
            .birth(birth)
            .build();
    }

    private Integer parseGender(String gender) {
        return gender.equals("male") ? Gender.MALE.ordinal() : Gender.FEMALE.ordinal();
    }

    private LocalDate parseBirth(String birthStr) {
        String[] yyyymmdd = birthStr.split("-");
        int year = Integer.parseInt(yyyymmdd[0]);
        int month = Integer.parseInt(yyyymmdd[1]);
        int day = Integer.parseInt(yyyymmdd[2]);
        return LocalDate.of(year, month, day);
    }
}
