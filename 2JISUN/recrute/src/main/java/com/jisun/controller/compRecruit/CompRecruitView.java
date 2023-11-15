package com.jisun.controller.compRecruit;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jisun.dao.CompRecruitDao;
import com.jisun.dto.CompRecruitDto;

@WebServlet("/compRecruit/view") // 클래스 이름 변경한 뒤 xml에서 인식못하는 문제 발생 -> 웹 서블릿으로 import
public class CompRecruitView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CompRecruitView() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*데이터 get : From Client(by a스트링)*/
		String recruitmenttbl_id_str = request.getParameter("recruitmenttbl_id"); 
		int recruitmenttbl_id = 0;
		if (recruitmenttbl_id_str!=null && !recruitmenttbl_id_str.isEmpty()) {
			recruitmenttbl_id = Integer.parseInt(recruitmenttbl_id_str);
		}
		
		
		
		/*데이터 get : From DB*/
		/*데이터 trans : Dao -> Dto -> Dto*/
		CompRecruitDao compRecruitDao = new CompRecruitDao();
		CompRecruitDto resultDto = compRecruitDao.selectCompRecruitView(recruitmenttbl_id);
		
		
		
		/*데이터 set : To Client*/
		request.setAttribute("compRecruitView", resultDto);
		
		
		
		/*페이지 연결*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/compRecruit/view.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
