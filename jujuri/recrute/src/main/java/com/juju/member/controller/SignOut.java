package com.juju.member.controller;

import java.io.IOException;
import com.juju.common.ScriptWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SignOut extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public SignOut() {
    super();

  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    session.invalidate();
    ScriptWriter.alertAndNext(response, "logged out", "/recrute/index");
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
