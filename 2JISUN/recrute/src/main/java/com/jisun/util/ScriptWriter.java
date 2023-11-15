package com.jisun.util;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletResponse;


/**
 * HttpServletResponse를 사용하여 JavaScript 경고창을 생성하고 메시지를 표시합니다.
 *
 * @param response HttpServletResponse 객체를 통해 클라이언트에게 응답을 보냅니다.
 * @param msg 경고창에 표시할 메시지입니다.
 * @param url 이동할 URL입니다.
 * @throws IOException 출력 중 예외가 발생하면 던집니다.
 */

public class ScriptWriter {
	// 경고 메시지를 출력하는 스크립트를 작성하는 메서드
    public static void alert(HttpServletResponse response, 
    						 String msg) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<script>");
        out.println("alert('" + msg + "')");
        out.println("</script>");
    }
    
    
    
    

    // 경고 메시지를 출력하고 지정된 URL로 이동하는 스크립트를 작성하는 메서드
    public static void alertAndNext(HttpServletResponse response, 
						    		String msg, 
						    		String url) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<script>");
        out.println("alert('" + msg + "');");
        out.println("location.href='" + url + "';");
        out.println("</script>");
    }
    
    
    
    

    // 경고 메시지를 출력하고 이전 페이지로 이동하는 스크립트를 작성하는 메서드
    public static void alertAndBack(HttpServletResponse response, 
    								String msg) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
			        out.println("<script>");
			        out.println("alert('" + msg + "');");
			        out.println("history.back();");
			        out.println("</script>");
    }
    
    
    
    
    
    // 경고 메시지를 출력하고 지정된 위치로 리다이렉트하는 스크립트를 작성하는 메서드
    public static void alertAndRedirect(HttpServletResponse response, 
							    		String msg, 
							    		String url) throws IOException {
    	
    	//응답의 콘텐츠 타입을 HTML로 설정하고 문자 인코딩을 UTF-8로 지정합니다.
        response.setContentType("text/html; charset=UTF-8");
        
        // JavaScript 스크립트를 저장할 문자열 변수를 초기화합니다.
        String script = "<script>";
	           script += "alert('" + msg + "');"; // 경고창을 표시하는 스크립트를 추가합니다.
	           script += "location.href='" + url + "';"; // 지정된 위치로 웹 페이지를 리다이렉트하는 스크립트를 추가합니다.
	           script += "</script>"; // JavaScript 스크립트 종료 태그를 추가합니다.
	    
	    //HttpServletResponse를 통해 JavaScript 스크립트를 클라이언트에게 출력합니다.
        response.getWriter().print(script);
    }
	

}
