package com.juju.controller.member;

import java.io.IOException;
import java.util.HashMap;
import com.google.gson.Gson;
import com.juju.dao.MemberDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class IdCheck extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public IdCheck() {
    super();

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String userId = request.getParameter("userId");
    MemberDao memberDao = new MemberDao();
    // System.out.println("userId===" + userId);
    int count = memberDao.IdCheck(userId);
    Gson gson = new Gson();
    HashMap<String, Integer> map = new HashMap<>();
    map.put("count", count);
    String resultJson = gson.toJson(map);
    System.out.println("count====" + resultJson);
    request.setAttribute("resultJson", resultJson);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/id-check.jsp");
    dispatcher.forward(request, response);
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

}
