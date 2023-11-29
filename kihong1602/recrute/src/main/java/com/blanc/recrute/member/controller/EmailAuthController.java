package com.blanc.recrute.member.controller;

import static com.blanc.recrute.common.Word.AUTH_KEY;

import com.blanc.recrute.common.CookieManager;
import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dto.ConfirmValueDTO;
import com.blanc.recrute.member.dto.ValidationDTO;
import com.blanc.recrute.member.service.EmailAuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "email", value = "/email")
public class EmailAuthController extends HttpServlet {

  private final EmailAuthService memberService = new EmailAuthService();

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
    HttpSession session = request.getSession(false);
    ConfirmValueDTO confirmValueDTO = JsonUtil.jsonParser(request, ConfirmValueDTO.class);

    String requestData = confirmValueDTO.getKey();
    String authKey = String.valueOf(UUID.randomUUID());
    String memberId = getMemberId(request, requestData);

    ValidationDTO validationDTO = memberService.sendAuthEmail(memberId, authKey);

    session.setAttribute(AUTH_KEY.value(), authKey);

    JsonUtil.sendJSON(response, validationDTO);
  }

  private void redirectConfirmPage(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String path = "member/register/email-confirm";
    ViewResolver.render(path, request, response);
  }

  private void authenticationProcess(HttpServletRequest request, HttpServletResponse response, String requestParamValue)
      throws ServletException, IOException {
    boolean authKeyValidationResult = validateAuthKey(request);

    Word result = memberService.authGrantMember(authKeyValidationResult, requestParamValue);

    request.setAttribute("result", result.value());

    String path = "member/register/email-auth";
    ViewResolver.render(path, request, response);
  }

  private boolean validateAuthKey(HttpServletRequest request) {
    String authKey = request.getParameter(AUTH_KEY.value());
    HttpSession session = request.getSession(false);
    String sessionAuthKey = (String) session.getAttribute(AUTH_KEY.value());
    return authKey.equals(sessionAuthKey);
  }

  private String getMemberId(HttpServletRequest request, String requestData) {
    String memberId;
    if (requestData.equals("sid")) {
      Cookie authCookie = CookieManager.getCookie(request, requestData);
      memberId = cookieValidation(request, authCookie);
    } else {
      memberId = requestData;
    }
    return memberId;
  }

  private String cookieValidation(HttpServletRequest request, Cookie authCookie) {
    if (authCookie != null) {
      return (String) request.getSession().getAttribute(authCookie.getValue());
    } else {
      throw new IllegalArgumentException("올바르지않은 인증 정보입니다.");
    }
  }
}
