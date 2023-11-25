package com.blanc.recrute.member.controller;

import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dto.ConfirmValueDTO;
import com.blanc.recrute.member.dto.ValidationDTO;
import com.blanc.recrute.member.service.MemberEmailAuthService;
import com.blanc.recrute.member.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "email", value = "/email")
public class EmailAuthorizationController extends HttpServlet {

  private final MemberService memberService = new MemberEmailAuthService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String requestParamValue = request.getParameter("email");

    if (requestParamValue == null) {
      redirectConfirmPage(request, response);
    } else {
      authenticationProcess(request, response, requestParamValue);
    }
  }


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ConfirmValueDTO confirmValueDTO = JsonUtil.jsonParser(request, ConfirmValueDTO.class);

    ValidationDTO validationDTO = memberService.sendAuthEmail(request, confirmValueDTO);

    JsonUtil.sendJSON(response, validationDTO);
  }

  private void redirectConfirmPage(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String path = "member/register/email-confirm";
    ViewResolver.render(path, request, response);
  }

  private void authenticationProcess(HttpServletRequest request, HttpServletResponse response, String requestParamValue)
      throws ServletException, IOException {
    Word result = memberService.authGrantMember(request, requestParamValue);

    request.setAttribute("result", result.value());

    String path = "member/register/email-auth";
    ViewResolver.render(path, request, response);
  }
}
