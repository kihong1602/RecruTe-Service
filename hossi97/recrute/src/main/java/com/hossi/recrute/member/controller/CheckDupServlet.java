package com.hossi.recrute.member.controller;

import com.hossi.recrute.common.http.JsonManager;
import com.hossi.recrute.common.service.anno.MBR;
import com.hossi.recrute.common.service.message.Message;
import com.hossi.recrute.common.service.message.MessageCreator;
import com.hossi.recrute.common.service.message.ResponseData;
import com.hossi.recrute.common.servlet.HttpController;
import com.hossi.recrute.member.dto.request.CheckDupReqDto;
import com.hossi.recrute.member.dto.response.CheckDupResDto;
import com.hossi.recrute.member.service.MemberService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

import static com.google.common.net.MediaType.JSON_UTF_8;
import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@WebServlet(name = "checkDupServlet", value = "/signup/check-duplicate")
public class CheckDupServlet extends HttpController {
    private final MemberService memberService = new MemberService();

    @Override @MBR(value = "003", description = "아이디 중복 조회")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CheckDupReqDto checkDupReqDto = new CheckDupReqDto(request.getParameter("username"));
        CheckDupResDto checkDupResDto = memberService.checkDuplicate(checkDupReqDto);
        ResponseData responseData = new ResponseData.Builder()
            .set("isDup", checkDupResDto.getIsDup())
            .build();
        Message<Map<String, Object>> message = MessageCreator.create(responseData);
        servletSetter()
            .setStatus(SC_OK, response)
            .setJson(JSON_UTF_8, JsonManager.toJson(message), response);
    }
}
