package com.jisun.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.jisun.dao.MemberDao;
import com.jisun.dto.MemberDto;


public class MemberIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public MemberIdCheck() {
        super();
    }



	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) throws ServletException, IOException {
		/*데이터 get : From client(by ajax)*/
		String member_id = request.getParameter("member_id");
		
		
		
		/*데이터 trans : dao->int->map*/
		MemberDao memberDao = new MemberDao();
		int count = memberDao.selectIdCheck(member_id); //0 or 1
		
		Gson gson = new Gson(); //클라이언트 요청 방식 : json으로 저장
		Map<String, Integer> map = new HashMap<>();
							 map.put("count", count);
		String resultJson = gson.toJson(map); //{"count": 0 or 1}

		
		
		/*데이터 set : To client*/
		request.setAttribute("resultJson", resultJson);
		
		
		/*페이지 연결*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/idCheckJson.jsp");
		dispatcher.forward(request, response);
		
		//성공시 jsp로 돌아가서 ajax의 success처리
		//실패시 jsp로 돌아가서 ajax의 error처리

	}


	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {

	}

}
