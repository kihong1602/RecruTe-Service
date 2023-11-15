package com.blanc.recrute.member.controller;

import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dto.InvalidDTO;
import com.blanc.recrute.member.dto.LoginDTO;
import com.blanc.recrute.member.service.MemberService;
import com.blanc.recrute.member.service.MemberServiceImpl;
import com.blanc.recrute.member.util.Authenticater;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signin", value = "/signin")
public class SignInController extends HttpServlet {

  private final MemberService MEMBER_SERVICE = new MemberServiceImpl();
  private final Authenticater AUTHENTICATER = new Authenticater();
  private final Gson GSON = new Gson();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (AUTHENTICATER.isAuthenticated(request)) {
      Cookie renewdAuthCookie = AUTHENTICATER.getAuthCookie();
      response.addCookie(renewdAuthCookie);
      response.setStatus(response.SC_FOUND);
      response.sendRedirect("/");
    } else {
      String path = "member/login/signin-process";
      ViewResolver.render(path, request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    String parsingJSON = JsonUtil.jsonParsing(request);

    LoginDTO loginDTO = GSON.fromJson(parsingJSON, LoginDTO.class);

    boolean check = MEMBER_SERVICE.loginCheck(loginDTO);
    InvalidDTO invalidDTO;
    String result;
    if (check) {
      invalidDTO = new InvalidDTO(Word.AVAILABLE);

      AUTHENTICATER.setAuthCookie(request, loginDTO.getMemberId());
      Cookie authCookie = AUTHENTICATER.getAuthCookie();
      response.addCookie(authCookie);
    } else {
      invalidDTO = new InvalidDTO(Word.UNAVAILABLE);
    }
    result = GSON.toJson(invalidDTO);

    JsonUtil.sendJSON(response, result);
  }
}
