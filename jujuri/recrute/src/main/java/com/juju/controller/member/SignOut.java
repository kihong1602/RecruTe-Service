package com.juju.controller.member;

import java.io.IOException;
import com.juju.util.ScriptWriter;
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
    ScriptWriter.alertAndNext(response, "로그아웃 됨", "/recrute/index");
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
