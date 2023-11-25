package com.blanc.recrute.member.controller;

import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.common.Authenticater;
import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.member.dto.InvalidDTO;
import com.blanc.recrute.member.dto.LoginDTO;
import com.blanc.recrute.member.service.MemberService;
import com.blanc.recrute.member.service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signin", value = "/signin")
public class SignInController extends HttpServlet {

  private final MemberService memberService = new MemberServiceImpl();
  private final Authenticater authenticater = new Authenticater();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (authenticater.isAuthenticated(request)) {
      Cookie renewdAuthCookie = authenticater.getAuthCookie();
      response.addCookie(renewdAuthCookie);
      response.setStatus(HttpServletResponse.SC_FOUND);
      response.sendRedirect("/");
    } else {
      String path = "member/login/signin-process";
      ViewResolver.render(path, request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    LoginDTO loginDTO = JsonUtil.JsonParser(request, LoginDTO.class);

    boolean check = memberService.loginCheck(loginDTO);
    InvalidDTO invalidDTO;

    if (check) {
      invalidDTO = new InvalidDTO(AVAILABLE);

      createAuthCookie(request, response, loginDTO);
    } else {
      invalidDTO = new InvalidDTO(UNAVAILABLE);
    }

    JsonUtil.sendJSON(response, invalidDTO);
  }

  private void createAuthCookie(HttpServletRequest request, HttpServletResponse response, LoginDTO loginDTO) {
    authenticater.setAuthCookie(request, loginDTO.getMemberId());
    Cookie authCookie = authenticater.getAuthCookie();
    response.addCookie(authCookie);
  }
}
