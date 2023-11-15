package com.blanc.recrute.member.controller;

import com.blanc.recrute.common.CookieManager;
import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dto.ConfirmValueDTO;
import com.blanc.recrute.member.dto.InvalidDTO;
import com.blanc.recrute.member.dto.MemberDTO;
import com.blanc.recrute.member.service.MemberService;
import com.blanc.recrute.member.service.MemberServiceImpl;
import com.blanc.recrute.member.service.SendEmailService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@WebServlet(name = "email", value = "/email")
public class EmailConfirmController extends HttpServlet {

  private final MemberService MEMBER_SERVICE = new MemberServiceImpl();
  private final Gson GSON = new Gson();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String path;
    if (request.getParameter("email") == null) {
      path = "member/register/email-confirm";
      ViewResolver.render(path, request, response);
    } else {
      //이메일에 있는 링크 클릭 후 AuthKey 판별해서 Auth-status 카운트하는곳
      String email = request.getParameter("email");
      String authKey = request.getParameter("authKey");
      if (request.getSession().getAttribute("authKey").equals(authKey)) {
        //email의 파라미터로 들어온 authKey가 session에 저장된 authKey와 동일하다면

        request.setAttribute("result", MEMBER_SERVICE.authGrantMember(email));
      } else {
        //동일하지 않다면..
        request.setAttribute("result", Word.FAIL);
      }
      path = "member/register/email-auth";
      ViewResolver.render(path, request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    long startTime = System.currentTimeMillis();
    String parsingJson = JsonUtil.jsonParsing(request);
    ConfirmValueDTO confirmValueDTO = GSON.fromJson(parsingJson, ConfirmValueDTO.class);

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

    //이메일 발송
    CompletableFuture<Void> emailFuture = CompletableFuture.runAsync(() -> {
      SendEmailService.mailSend(memberDTO.getEmail(), authKey);
    });
//    SendEmailService.mailSend(emailInfoDTO, authKey);
    InvalidDTO invalidDTO = new InvalidDTO(Word.AVAILABLE);
    request.getSession().setAttribute("authKey", authKey);

    String result = GSON.toJson(invalidDTO);
    JsonUtil.sendJSON(response, result);

    /*try {
      emailFuture.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }*/
    long endTime = System.currentTimeMillis();

    long elapsedTime = endTime - startTime;
    System.out.println("이메일 전송 시간: " + elapsedTime + "밀리초");
  }
}
