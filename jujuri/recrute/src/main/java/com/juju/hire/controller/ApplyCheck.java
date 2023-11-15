package com.juju.hire.controller;

import java.io.IOException;
import java.util.HashMap;
import com.google.gson.Gson;
import com.juju.hire.dao.ApplicantDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ApplyCheck extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ApplyCheck() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    String userId = (String) session.getAttribute("loggedID");
    ApplicantDao applicantDao = new ApplicantDao();
    int count = applicantDao.checkApplicant(userId);

    Gson gson = new Gson();
    HashMap<String, Integer> map = new HashMap<>();
    map.put("count", count);
    String resultJson = gson.toJson(map);
    request.setAttribute("resultJson", resultJson);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/hire/apply-check.jsp");
    dispatcher.forward(request, response);
  }


}
