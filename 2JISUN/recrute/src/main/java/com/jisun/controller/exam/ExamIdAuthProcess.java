package com.jisun.controller.exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jisun.dao.ExamDao;
import com.jisun.dto.ExamDto;
import com.jisun.util.EmailManager;
import com.jisun.util.ScriptWriter;

@WebServlet("/exam/idAuth-process") // 클래스 이름 변경한 뒤 xml에서 인식못하는 문제 발생 -> 웹 서블릿으로 import
public class ExamIdAuthProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ExamIdAuthProcess() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*데이터 get : From Session (by 로그인ing)*/
		HttpSession session = request.getSession();
		int loggedId = 0;
		String loggedIdStr = String.valueOf(session.getAttribute("loggedId")); 
		if(loggedIdStr!=null && !loggedIdStr.isEmpty()) {
			loggedId = Integer.parseInt(loggedIdStr);
		}
		
		/*데이터 get : From Client (by form)*/
		int apt_id= 0;
		if(request.getParameter("apt_id")!=null && !request.getParameter("apt_id").isEmpty()) {
			apt_id = Integer.parseInt(request.getParameter("apt_id"));
		}
		
		
		/*데이터 trans : Dao -> int (수험번호 일치)
		 * 			   Dao -> Dto (시험문제 전달)*/
		ExamDao examDao = new ExamDao();
		ExamDto examDto = new ExamDto();
				examDto.setMembertbl_id(loggedId);
				examDto.setApt_id(apt_id);

		int resultInt = examDao.selectAptIdCheck(examDto); //수험번호 일치
		ExamDto resultDto = examDao.selectExamQuestion(examDto); //시험문제 전달

		
		if(resultInt>0) {
			/*데이터 set : To Client*/
			request.setAttribute("examQuestion", resultDto);
			ScriptWriter.alertAndNext(response, "시험시작합니다", "../exam/exam");
		} else {
			ScriptWriter.alertAndBack(response, "수험번호를 다시 입력해주세요");
			
		}


	}

}
