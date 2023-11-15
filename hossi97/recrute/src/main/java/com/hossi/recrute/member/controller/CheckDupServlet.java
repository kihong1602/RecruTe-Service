package com.hossi.recrute.member.controller;

import com.google.gson.Gson;
import com.hossi.recrute.member.dto.request.CheckDupReqDto;
import com.hossi.recrute.member.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "checkDupServlet", value = "/signup/check-duplicate")
public class CheckDupServlet extends HttpServlet {
    MemberService memberService = new MemberService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CheckDupReqDto checkDupReqDto = new CheckDupReqDto(request.getParameter("memberId"));
        String resDataJson = new Gson().toJson(memberService.checkDuplicate(checkDupReqDto));
        response.setContentType("application/json");
        response.setContentLength(resDataJson.length());
        response.getWriter().write(resDataJson);
    }
}
