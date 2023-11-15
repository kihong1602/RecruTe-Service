package com.hossi.recrute.member.controller;


import com.hossi.recrute.common.ViewResolver;
import com.hossi.recrute.member.dto.request.SignupDto;
import com.hossi.recrute.member.service.MemberService;
import com.hossi.recrute.member.vo.GenderVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="signupServlet", value="/signup")
public class SignupServlet extends HttpServlet {
    private final MemberService memberService = new MemberService();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("mainViewPath", ViewResolver.resolveMainViewPath("signup"));
        request.getRequestDispatcher(ViewResolver.getMainViewPath()).forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        GenderVo gender = request.getParameter("gender").equals("male") ? GenderVo.MALE : GenderVo.FEMALE;
        String birthStr = request.getParameter("birth");
        String[] yymmdd = birthStr.split("-");
        int year = Integer.parseInt(yymmdd[0]);
        int month = Integer.parseInt(yymmdd[1]);
        int day = Integer.parseInt(yymmdd[2]);
        LocalDate birth = LocalDate.of(year, month, day);

        SignupDto signupDto = new SignupDto.Builder()
            .memberId(request.getParameter("id"))
            .email(request.getParameter("email"))
            .name(request.getParameter("name"))
            .gender(gender.ordinal())
            .password(request.getParameter("password"))
            .passwordConfirm(request.getParameter("passwordConfirm"))
            .phoneNumber(request.getParameter("phoneNumber"))
            .birth(birth)
            .build();

        if(memberService.signup(signupDto)) {
            response.setStatus(302);
            response.sendRedirect("/");
        }
    }
}
