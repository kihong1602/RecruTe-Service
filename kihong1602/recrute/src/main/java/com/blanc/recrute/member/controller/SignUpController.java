package com.blanc.recrute.member.controller;

import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.UserAuthenticator;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.member.dto.MemberInfoDTO;
import com.blanc.recrute.member.dto.ValidationDTO;
import com.blanc.recrute.member.service.RegistrationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signup", value = "/signup")
public class SignUpController extends HttpServlet {

  private final RegistrationService memberService = new RegistrationService();
  private final UserAuthenticator userAuthenticator = new UserAuthenticator();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String path;
    if (userAuthenticator.isAuthenticated(request)) {
      sendRedirectIndexPage(response);
      return;
    } else {
      path = "member/register/signup-process";
    }

    ViewResolver.render(path, request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    MemberInfoDTO memberDto = JsonUtil.jsonParser(request, MemberInfoDTO.class);

    ValidationDTO validationDTO = memberService.memberRegistration(memberDto);

    JsonUtil.sendJSON(response, validationDTO);
  }

  private void sendRedirectIndexPage(HttpServletResponse response) throws IOException {
    response.setStatus(HttpServletResponse.SC_FOUND);
    response.sendRedirect("/");
  }
}
