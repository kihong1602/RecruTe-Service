package com.jisun.controller.exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exam/exam") // 클래스 이름 변경한 뒤 xml에서 인식못하는 문제 발생 -> 웹 서블릿으로 import
public class Exam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Exam() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher를 사용하여 JSP 페이지로 포워딩합니다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/exam/exam.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
