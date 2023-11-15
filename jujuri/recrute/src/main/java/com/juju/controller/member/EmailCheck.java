package com.juju.controller.member;

import java.io.IOException;
import java.util.HashMap;
import com.google.gson.Gson;
import com.juju.util.EmailManager;
import com.juju.util.MakeRandomCode;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class EmailCheck extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public EmailCheck() {
    super();

  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String email = request.getParameter("email");
    String hostName = email.substring(email.lastIndexOf("@") + 1, email.lastIndexOf("."));
    String code = MakeRandomCode.randomCharacter(8);
    boolean isSend = EmailManager.mailSend(hostName, email, "email verification", code);

    String sent = "";
    if (isSend = true) {
      sent = "true";
    } else {
      sent = "false";
    }
    Gson gson = new Gson();
    HashMap<String, String> map = new HashMap<>();
    map.put("sent", sent);
    map.put("code", code);
    String resultJson = gson.toJson(map);
    System.out.println("result=====" + resultJson);
    request.setAttribute("resultJson", resultJson);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/email-check.jsp");
    dispatcher.forward(request, response);
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

  public static void main(String[] args) {

  }

}
