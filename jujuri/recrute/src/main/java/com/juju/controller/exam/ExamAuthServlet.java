package com.juju.controller.exam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.juju.dao.ExamDao;
import com.juju.dto.ExamDto;
import com.juju.util.ScriptWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/// exam/{exam_id}/auth
public class ExamAuthServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ExamAuthServlet() {
    super();

  }

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String[] url = request.getRequestURI().split("/");
    // System.out.println(url[4]);
    // ex) /recrute/exam/1/auth ==> [, recrute, exam, 1, auth]

    if (url.length > 3) {
      if (url[4].equals("auth")) {

        String examId = url[3];
        request.setAttribute("examId", examId);
        RequestDispatcher dispatcher =
            request.getRequestDispatcher("/WEB-INF/exam/authorization.jsp");
        dispatcher.forward(request, response);
      }
    } else {
      String aptId = request.getParameter("aptId");
      String examId = request.getParameter("examId");

      ExamDao examDao = new ExamDao();
      List<ExamDto> examList = new ArrayList<>();

      examList = examDao.selectProblems(aptId);
      System.out.println(examList);

      if (!examList.isEmpty()) {
        request.setAttribute("examId", examId);
        request.setAttribute("examList", examList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/exam/exam-view.jsp");
        dispatcher.forward(request, response);

      } else {
        ScriptWriter.alertAndBack(response, "error");
      }
    }


  }



}
