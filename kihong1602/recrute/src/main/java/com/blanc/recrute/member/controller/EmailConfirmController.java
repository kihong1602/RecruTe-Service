package com.blanc.recrute.member.controller;

import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.FAIL;

import com.blanc.recrute.common.CookieManager;
import com.blanc.recrute.common.EmailService;
import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.member.dto.ConfirmValueDTO;
import com.blanc.recrute.member.dto.InvalidDTO;
import com.blanc.recrute.member.dto.MemberDTO;
import com.blanc.recrute.member.service.MemberService;
import com.blanc.recrute.member.service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
      //이메일에 있는 링크 클릭 후 AuthKey 판별해서 Auth-status 카운트하는곳
      String email = request.getParameter("email");
      String authKey = request.getParameter("authKey");
      if (request.getSession().getAttribute("authKey").equals(authKey)) {
        //email의 파라미터로 들어온 authKey가 session에 저장된 authKey와 동일하다면

        request.setAttribute("result", MEMBER_SERVICE.authGrantMember(email).value());
      } else {
        //동일하지 않다면..
        request.setAttribute("result", FAIL.value());
      }
      path = "member/register/email-auth";
      ViewResolver.render(path, request, response);
    }
  }


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ConfirmValueDTO confirmValueDTO = JsonUtil.JsonParser(request, ConfirmValueDTO.class);

    String memberId = confirmValueDTO.getKey();

    if (confirmValueDTO.getKey().equals("sid")) {
      //AuthCookie 의 Key 가 왔을 시
      Cookie AuthCookie = CookieManager.getCookie(request, confirmValueDTO.getKey());
      if (AuthCookie != null) {
        memberId = (String) request.getSession().getAttribute(AuthCookie.getValue());
      }
    }

    MemberDTO memberDTO = MEMBER_SERVICE.findEmail(memberId);
    String authKey = String.valueOf(UUID.randomUUID());

    emailService.SendMemberAuthEmail(memberDTO.getEmail(), authKey);

    InvalidDTO invalidDTO = new InvalidDTO(AVAILABLE);
    request.getSession().setAttribute("authKey", authKey);

    JsonUtil.sendJSON(response, invalidDTO);

  }

  private void redirectConfirmPage(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String path = "member/register/email-confirm";
    ViewResolver.render(path, request, response);
  }
}
