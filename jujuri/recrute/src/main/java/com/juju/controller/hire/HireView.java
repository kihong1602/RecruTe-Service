package com.juju.controller.hire;

import java.io.IOException;
import com.juju.dao.HireDao;
import com.juju.dto.HireDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HireView extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public HireView() {
    super();

  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int recruitId = Integer.parseInt(request.getParameter("recruitId"));
    HireDao hireDao = new HireDao();
    HireDto viewHire = hireDao.getJobPosting(recruitId);
    request.setAttribute("viewHire", viewHire);
    // System.out.println(viewHire.getId());
    // HttpSession session = request.getSession();

    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/hire/view.jsp");
    dispatcher.forward(request, response);
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

}
