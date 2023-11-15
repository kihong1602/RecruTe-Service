package com.jisun.controller.compRecruit;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.jisun.dao.CompRecruitDao;
import com.jisun.dto.CompRecruitDto;

@WebServlet("/compRecruit/list") // 클래스 이름 변경한 뒤 xml에서 인식못하는 문제 발생 -> 웹 서블릿으로 import
public class CompRecruitList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    public CompRecruitList() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*데이터 get : From DB*/
		/*데이터 trans : Dao -> (Dto) -> List*/
		CompRecruitDao compRecruitDao = new CompRecruitDao();   
		List<CompRecruitDto> resultList = compRecruitDao.selectCompRecruitList();
		
		/*데이터 set : To client*/
		request.setAttribute("compRecruitList", resultList);
		
		
		/*페이지 연결*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/compRecruit/list.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
