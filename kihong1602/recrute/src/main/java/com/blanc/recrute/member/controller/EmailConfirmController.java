package com.blanc.recrute.member.controller;

import static com.blanc.recrute.common.Word.AUTH_KEY;
import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.FAIL;

import com.blanc.recrute.common.CookieManager;
import com.blanc.recrute.common.EmailService;
import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dto.ConfirmValueDTO;
import com.blanc.recrute.member.dto.InvalidDTO;
import com.blanc.recrute.member.service.MemberService;
import com.blanc.recrute.member.service.MemberServiceImpl;
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
public class EmailConfirmController extends HttpServlet {

  private final MemberService MEMBER_SERVICE = new MemberServiceImpl();

  private final EmailService emailService = new EmailService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String path;
    if (request.getParameter("email") == null) {
      redirectConfirmPage(request, response);
    } else {

      String email = request.getParameter("email");
      String authKey = request.getParameter(AUTH_KEY.value());

      HttpSession session = request.getSession();
      String sessionAuthKey = (String) session.getAttribute(AUTH_KEY.value());

      if (sessionAuthKey.equals(authKey)) {
        Word result = MEMBER_SERVICE.authGrantMember(email);
        request.setAttribute("result", result.value());
      } else {
        request.setAttribute("result", FAIL.value());
      }
      path = "member/register/email-auth";
      ViewResolver.render(path, request, response);
    }
  }


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ConfirmValueDTO confirmValueDTO = JsonUtil.jsonParser(request, ConfirmValueDTO.class);
    HttpSession session = request.getSession(false);

    String requestData = confirmValueDTO.getKey();
    String memberId = "";

    if (requestData.equals("sid")) {

      Cookie authCookie = CookieManager.getCookie(request, requestData);

      if (authCookie != null) {
        memberId = (String) session.getAttribute(authCookie.getValue());
      }

    } else {
      memberId = requestData;
    }

    String memberEmail = MEMBER_SERVICE.findEmail(memberId);
    String authKey = String.valueOf(UUID.randomUUID());

    emailService.sendMemberAuthEmail(memberEmail, authKey);

    InvalidDTO invalidDTO = new InvalidDTO(AVAILABLE);
    session.setAttribute(AUTH_KEY.value(), authKey);

    JsonUtil.sendJSON(response, invalidDTO);
  }

  private void redirectConfirmPage(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String path = "member/register/email-confirm";
    ViewResolver.render(path, request, response);
  }
}
