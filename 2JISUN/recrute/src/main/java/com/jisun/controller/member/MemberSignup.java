package com.jisun.controller.member;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberSignup() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher를 사용하여 JSP 페이지로 포워딩합니다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/signup.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}