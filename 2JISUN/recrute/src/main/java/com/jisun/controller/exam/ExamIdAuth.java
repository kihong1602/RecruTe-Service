package com.jisun.controller.exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jisun.dao.CompRecruitDao;
import com.jisun.dao.ExamDao;
import com.jisun.dto.CompRecruitDto;
import com.jisun.dto.ExamDto;

@WebServlet("/exam/idAuth") // 클래스 이름 변경한 뒤 xml에서 인식못하는 문제 발생 -> 웹 서블릿으로 import
public class ExamIdAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExamIdAuth() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// RequestDispatcher를 사용하여 JSP 페이지로 포워딩합니다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/exam/idAuth.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
