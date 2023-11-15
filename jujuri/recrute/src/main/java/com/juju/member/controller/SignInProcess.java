package com.juju.member.controller;

import java.io.IOException;
import java.util.HashMap;
import com.google.gson.Gson;
import com.juju.common.CookieManager;
import com.juju.member.dao.MemberDao;
import com.juju.member.dto.MemberDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class SignInProcess extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public SignInProcess() {
    super();

  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String userId = request.getParameter("userId");
    String pw = request.getParameter("pw");
    String saveID = request.getParameter("saveID");

    MemberDto memberDto = new MemberDto();
    memberDto.setMember_id(userId);
    memberDto.setPassword(pw);


    MemberDto loginResult = new MemberDto();

    MemberDao memberDao = new MemberDao();
    loginResult = memberDao.loginMember(memberDto);

    if (loginResult != null && saveID != null) {
      if (saveID.equals("rememberMe")) {
        CookieManager.createCookie(response, "saveIDCookie", userId, 60 * 60 * 24);
      } else {
        CookieManager.deleteCookie(response, "saveIDCookie");
      }
    }
    if (loginResult != null) {
      HttpSession session = request.getSession();
      session.setAttribute("loggedID", loginResult.getMember_id());
      session.setAttribute("loggedName", loginResult.getName());
      String id = loginResult.getMember_id();
      String pw02 = loginResult.getPassword();



      HashMap<String, String> loginMap = new HashMap<>();
      loginMap.put("id", id);
      loginMap.put("pw", pw02);


      Gson gson = new Gson();
      String resultJson = gson.toJson(loginMap);


      request.setAttribute("resultJson", resultJson);


      RequestDispatcher dispatcher =
          request.getRequestDispatcher("/WEB-INF/member/login-complete.jsp");
      dispatcher.forward(request, response);
    }

  }

}
