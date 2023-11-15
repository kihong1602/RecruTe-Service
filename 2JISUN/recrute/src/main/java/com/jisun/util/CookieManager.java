package com.jisun.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieManager {
	
	//cookie create 생성
	public static void createCookie(HttpServletResponse response, //http로 데이터 보낼 때
									String cookieName, //쿠키 이름 (saveIDCookie)
									String cookieValue, //쿠키 값 (userId : love, mark)
									int time) { //쿠키 시간
		// 새로운 쿠키 객체를 생성합니다.
		Cookie cookie = new Cookie(cookieName, cookieValue);	
			   cookie.setPath("/");// 쿠키의 경로 = 루트 (페이지 단위)
			   cookie.setMaxAge(time);// 쿠키의 수명 (시간 단위).

		// 응답에 쿠키를 추가
		response.addCookie(cookie); 
	}
	
	
	//cookie read 유지 
	public static String readCookie(HttpServletRequest request, 
					 				String cookieName) {
		// 현재 요청에서 모든 쿠키를 가져옵니다.
		Cookie cookies [] = request.getCookies();
		
		// 원하는 쿠키의 값을 저장합니다.
		String cookieValue = "";
		if(cookies!=null) {
			for(Cookie c : cookies) { // 모든 쿠키를 반복하여 원하는 쿠키를 찾습니다.
				if(c.getName().equals(cookieName)) {
					cookieValue = c.getValue(); // 원하는 쿠키의 값을 저장합니다.
				}
			}
		}
		return cookieValue; // 찾은 쿠키의 값을 반환합니다.
	}
	
	
	
	
	//cookie delete 삭제
	public static void deleteCookie(HttpServletResponse response, 
			   						String cookieName) {
		//time을 0으로 처리하여 쿠키 만료시키기
		createCookie(response, cookieName, "", 0);
		}

}
