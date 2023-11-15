package com.jisun.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jisun.util.ScriptWriter;


public class MemberSignoutProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberSignoutProcess() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
					session.invalidate(); //세션 무효화 = 로그아웃
		ScriptWriter.alertAndNext(response, "로그아웃 되었습니다.", "../index/index");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

