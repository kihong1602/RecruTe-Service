package com.jisun.controller.member;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import com.jisun.dao.MemberDao;
import com.jisun.dto.MemberDto;
import com.jisun.util.EmailManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberSignupProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberSignupProcess() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*From client(by form)*/
		String member_id = request.getParameter("member_id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birthStr = request.getParameter("birth");
		LocalDate birth = LocalDate.parse(birthStr, DateTimeFormatter.ISO_DATE);
		int gender = 0;
			if(request.getParameter("gender")!=null && !request.getParameter("gender").isEmpty()) {
				gender = Integer.parseInt(request.getParameter("gender"));
			}
		String phone_number = request.getParameter("phone_number");
		String email = request.getParameter("email");


		/*데이터 변환*/
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
				memberDto.setMember_id(member_id);
				memberDto.setPassword(password);
				memberDto.setName(name);
				memberDto.setEmail(email);
				memberDto.setBirth(birth);
				memberDto.setGender(gender);
				memberDto.setPhone_number(phone_number);
				
		// 메일을 보내기 위한 변수 할당
		String hostName = null;
        String[] emailParts = email.split("@"); // @를 기준으로 아이디와 호스트를 분리
        if(emailParts.length == 2) {
        	// String emailId = emailParts[0];
        	hostName = emailParts[1].replace(".com", ""); // .com 제거
        }
        String sendEmail = "snm03097@naver.com";
        String sendPw = "Universe96";
        String subject = "Thank you Sign up to RecruTe!";
		String content = "환영합니다!";
				  
		int resultInt = memberDao.insertInfoMember(memberDto); 
		if(resultInt>0) {
			EmailManager.mailSend(sendEmail, sendPw, hostName, email, subject, content);
			response.sendRedirect("../member/signin");
		} else {
			response.sendRedirect("../member/signup");
		}
	}
}
