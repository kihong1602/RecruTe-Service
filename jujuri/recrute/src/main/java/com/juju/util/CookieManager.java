//내가 만든 쿠키~매니저 클래스 (생성, 삭제, 읽기 메소드를 만들어둠)

package com.juju.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieManager {
	public static void createCookie(HttpServletResponse response, String cookieName, String cookieValue, int time) {
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setPath("/");
		cookie.setMaxAge(time);
		response.addCookie(cookie);
	}
	public static void deleteCookie(HttpServletResponse response, String cookieName) {
		createCookie(response, cookieName, "mean", 0);
	}
	public static String readCookie(HttpServletRequest request, String cookieName) {
		String cookieValue = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(cookieName)) {
					cookieValue = c.getValue();
				}
			}
		}
		return cookieValue; 
	}
}
