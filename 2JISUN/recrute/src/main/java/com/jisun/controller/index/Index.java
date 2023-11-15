package com.jisun.controller.index;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Index() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher를 사용하여 JSP 페이지로 포워딩합니다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index/index.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
