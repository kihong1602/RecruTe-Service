package com.jisun.controller.Test;

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


public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Test() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*데이터 가져오는 방법*/
		
		/*[클라이언트(jsp)] > 없음*/
		
		/*[직접] > 없음*/

		
		/*session*/
		int loggedId = 0;
		HttpSession session = request.getSession();
		String loggedIdStr = String.valueOf(session.getAttribute("loggedId"));
		if(loggedIdStr!=null && !loggedIdStr.isEmpty()) {
			loggedId = Integer.parseInt(loggedIdStr);
		}
		
		
		/*
		[DB(dao,xml)-1) -> list/string/list/hashmap...
		 */
		//CompRecruitDao compRecruitDao = new CompRecruitDao();
		//String title = compRecruitDao.selectCompRecruitTitle(loggedId);
		
		/*
		 [DB(dao,xml)-2] -> dto
		 */
		ExamDao examDao = new ExamDao();
		ExamDto examDto = examDao.selectExamAuth(loggedId);
						  examDto.getExamTbl_id();
						  examDto.getApplicantTbl_id();
						  
		//List<Integer> examIdList =  examDao.selectExamIdList();

		
		
		//String url = "http://localhost:8080/recrute02/exam/examId?examtbl_id=" + examId + "/auth";				  
		
						  
						  
						  
		  
		/*
		 * 데이터 저장하기 
		 */
		//request.setAttribute("examIdList", examIdList); // 시험T의 id를 list로 저장
		request.setAttribute("examAuth", examDto); //시험T의 id, 지원자T의 apt_id
		//request.setAttribute("title", title); //타이틀

		
		
		//RequestDispatcher를 사용하여 JSP 페이지로 포워딩합니다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/exam/examIdAuth.jsp");
		dispatcher.forward(request, response);
	}

}
