package com.blanc.recrute.member.controller;

import static com.blanc.recrute.common.Word.AVAILABLE;

import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.UserAuthenticator;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.member.dto.LoginDTO;
import com.blanc.recrute.member.dto.ValidationDTO;
import com.blanc.recrute.member.service.MemberLoginService;
import com.blanc.recrute.member.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signin", value = "/signin")
public class LoginController extends HttpServlet {

  private final MemberService memberService = new MemberLoginService();
  private final UserAuthenticator userAuthenticator = new UserAuthenticator();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    checkAuthenticationStatus(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    LoginDTO loginDTO = JsonUtil.jsonParser(request, LoginDTO.class);

    ValidationDTO validationDTO = memberService.loginCheck(loginDTO);
    if (dtoIsEquals(validationDTO)) {
      createAuthCookie(request, response, loginDTO);
    }

    JsonUtil.sendJSON(response, validationDTO);
  }

  private void checkAuthenticationStatus(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    if (userAuthenticator.isAuthenticated(request)) {
      renewAuthCookieAndRedirect(response, userAuthenticator);
    } else {
      String path = "member/login/signin-process";
      ViewResolver.render(path, request, response);
    }
  }

  private void renewAuthCookieAndRedirect(HttpServletResponse response, UserAuthenticator userAuthenticator)
      throws IOException {
    Cookie renewdAuthCookie = userAuthenticator.getAuthCookie();
    response.addCookie(renewdAuthCookie);
    response.setStatus(HttpServletResponse.SC_FOUND);
    response.sendRedirect("/");
  }

  private void createAuthCookie(HttpServletRequest request, HttpServletResponse response, LoginDTO loginDTO) {
    userAuthenticator.setAuthCookie(request, loginDTO.getMemberId());
    Cookie authCookie = userAuthenticator.getAuthCookie();
    response.addCookie(authCookie);
  }

  private boolean dtoIsEquals(ValidationDTO validationDTO) {
    return validationDTO.getData().equals(AVAILABLE.value());
  }
}
