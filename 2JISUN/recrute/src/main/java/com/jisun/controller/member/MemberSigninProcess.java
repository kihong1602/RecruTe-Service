package com.jisun.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.jisun.dao.MemberDao;
import com.jisun.dto.MemberDto;
import com.jisun.dto.ModalDto;
import com.jisun.dto.ModalState;
import com.jisun.util.CookieManager;
import com.jisun.util.ScriptWriter;


public class MemberSigninProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberSigninProcess() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {

		/*데이터 get : From client(by ajax)*/
		String member_id = request.getParameter("member_id"); 
		String password = request.getParameter("password"); 
		String save_id = request.getParameter("save_id"); 
		
		/*데이터 trans*/
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
				  memberDto.setMember_id(member_id);
				  memberDto.setPassword(password);

		MemberDto resultDto = memberDao.selectLoginMember(memberDto); //select id, member_id as memberID , password , name, email
		
		
		
		//데이터가 존재하면 로그인 없으면 알림창
		if(resultDto!=null) {
			
			/*데이터 set : To 세션*/
			//로그인 상태 유지를 위해 세션 추가
			HttpSession session = request.getSession();
						session.setAttribute("loggedId", resultDto.getMembertbl_id()); 
						session.setAttribute("loggedMemberId", resultDto.getMember_id());
						session.setAttribute("loggedName", resultDto.getName()); 
						session.setAttribute("loggedEmail", resultDto.getEmail());
			
						
			/*데이터 set : To 쿠키*/
			if(save_id!=null){ //input > type(checkbox) > value속성의 값과 일치할 경우 쿠키를 생성한다.
			//페이지 방문 경험이 있고 로그인을 해본경우
				if(save_id.equals("rememberMe")) { //saveId value="rememberMe"일 경우
					//토글 on
					CookieManager.createCookie(response, "saveIdCookie", member_id, 60*60*24*365); //1년
				} else { 
					//토글 off
					CookieManager.deleteCookie(response, "saveIdCookie");
				}
			} else {
			//페이지 방문경험이 없음
				CookieManager.deleteCookie(response, "saveIdCookie");
			}
	
			
			/*데이터 trans*/
			Map<String, String> map = new HashMap<>();
							  //map.put("String", String);
								map.put("member_id", resultDto.getMember_id());
								map.put("password", resultDto.getPassword());
			Gson gson = new Gson();
			String resultJson = gson.toJson(map);
			
			/*데이터 set : To 클라이언트(by json)*/
			request.setAttribute("resultJson", resultJson);
			
			
			
			/*페이지 연결*/
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/signinJson.jsp");
			dispatcher.forward(request, response);
			
			
			
			//성공시 signin.jsp로 돌아가서 ajax의 success처리
			//실패시 signin.jsp로 돌아가서 ajax의 error처리
			
		} 
	}
}
