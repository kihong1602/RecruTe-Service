package com.juju.member.controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignIn extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public SignIn() {
    super();

  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/signin.jsp");
    dispatcher.forward(request, response);
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doGet(request, response);
  }

}
