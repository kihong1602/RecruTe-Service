package com.jisun.controller.applicant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jisun.dao.ApplicantDao;
import com.jisun.dao.ExamDao;
import com.jisun.dto.ApplicantDto;
import com.jisun.dto.ExamDto;
import com.jisun.util.EmailManager;
import com.jisun.util.RandomGenerator;
import com.jisun.util.ScriptWriter;


public class ApplicantProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ApplicantProcess() {
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
		//String loggedMemberId = String.valueOf(session.getAttribute("loggedMemberId")); 
		String loggedEmail = String.valueOf(session.getAttribute("loggedEmail"));

		
		/*데이터 get : From Client (by form)*/
		int recruitmenttbl_id = 0;
			if(request.getParameter("recruitmenttbl_id")!=null && !request.getParameter("recruitmenttbl_id").isEmpty()) {
				recruitmenttbl_id = Integer.parseInt(request.getParameter("recruitmenttbl_id"));
			}
		
			
		// 메일을 보내기 위한 변수 할당
		String hostName = null;
        String[] emailParts = loggedEmail.split("@"); // @를 기준으로 아이디와 호스트를 분리
        if(emailParts.length == 2) {
        	//String emailId = emailParts[0];
        	hostName = emailParts[1].replace(".com", ""); // .com 제거 > naver /google
        }
        String sendEmail = "snm03097@naver.com";
        String sendPw 	 = "Universe96";
        String subject 	 = "회원님 지원하신 " 
        					+ request.getParameter("company_name") 
        					+ "의 수험번호와 시험응시 페이지 링크를 전달드립니다.";

        int apt_id = RandomGenerator.RandomNum(); //랜덤숫자 생성(1000~9999)
        
		String url = "http://localhost:8080/recrute02/exam/idAuth";
		String content = "수험번호를 아래 페이지에서 입력하세요" 
						+ "\n"
						+ "회원님의 수험번호 : " + apt_id 
						+ "\n" 
						+ "시험 보러 가기: " + url;

			
		/*데이터 trans : Dao -> Dto -> int */
		ApplicantDao applicantDao = new ApplicantDao();
		ApplicantDto applicantDto = new ApplicantDto();
					 applicantDto.setApt_id(apt_id); 
					 applicantDto.setMembertbl_id(loggedId);
					 applicantDto.setRecruitmenttbl_id(recruitmenttbl_id);;	 	
		int resultInt = applicantDao.insertAppliacnt(applicantDto);
		
		
		/*결과 : 메서드 수행*/
		if (resultInt>0) {
			EmailManager.mailSend(sendEmail, sendPw, hostName, loggedEmail, subject, content);
			ScriptWriter.alertAndBack(response, "지원 성공! 회원님의 이메일로 시험링크가 발송되었습니다. 행운을 빌어요~🍀");
		} else {
			ScriptWriter.alertAndBack(response, "서버 오류 입니다.");
		}
	}
}


