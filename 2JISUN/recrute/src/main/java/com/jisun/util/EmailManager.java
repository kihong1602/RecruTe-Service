package com.jisun.util;


import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailManager {
	
	// 메일 전송 하기 
	// 정적(static) 방식으로 호출해야함 > 객체를 따로 만들면 안됨
	// EmailManager.mailSend(hostName, sendEmail, password, email);
    public static boolean mailSend(String sendEmail, //보내는 사람의 이메일
					    		   String sendPw,  //보내는 사람의 비밀번호
					    		   String hostName, // 받는 사람의 호스트(네이버, 구글, 카카오)
					    		   String receiveEmail, //받는 사람의 이메일
					    		   String subject, //메일 제목
					    		   String content //메일 내용
					    		   ) { 
    	
        Properties props = setProperties(hostName); // 속성 설정
        return props != null && sendEmail(props, sendEmail, sendPw, receiveEmail, subject, content);
    }

    
    // 메일 전송 전 : 호스트 속성 설정 (네이버, 구글, 카카오 등등..)
    private static Properties setProperties(String hostName) {
        switch (hostName) {
            case "naver":
                String host = "smtp.naver.com";
                
                Properties props = new Properties();
		                   props.put("mail.smtp.host", host);
		                   props.put("mail.smtp.port", 587);
		                   props.put("mail.smtp.auth", "true");
		                   
                return props;
                
                
            case "gmail":
                host = "smtp.gmail.com";

                props = new Properties();
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", 465);
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.ssl.enable", "true");
                props.put("mail.smtp.ssl.trust", host);
                return props;
            default:
                return null;
        }
    }

    
    // 메일 전송 전 : 메일 보내는 사람의 비밀번호 사용 권한 얻기 
    private static boolean sendEmail(Properties props, //네이버, 구글, 카카오
    								 String sendEmail, //보내는 사람의 이메일
						    		 String sendPw, //보내는 사람의 비밀번호
						    		 String receiveEmail, //받는 사람의 이메일
						    		 String subject, //메일 제목
						    		 String content) { //메일 내용
        //권한 등록
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendEmail, sendPw);
            }
        });
        
        //내용 작성
        try {
            Message message = new MimeMessage(session);

		            message.setFrom(new InternetAddress(sendEmail));
		            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiveEmail));
		
		            message.setSubject(subject);
		            message.setText(content);
		            
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
