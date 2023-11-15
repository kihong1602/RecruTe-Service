package com.blanc.recrute.member.service;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dto.EmailInfoDTO;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SendEmailService {

  private static final Logger LOGGER = Logger.getLogger(SendEmailService.class.getName());
  private static final String HOST = "gmail";

  public static void mailSend(String receiveEmail, String authKey) {
    EmailInfoDTO emailInfoDTO = new EmailInfoDTO(receiveEmail);
    Properties props = setProperties();

    sendEmail(emailInfoDTO, authKey, props);
  }

  private static Properties setProperties() {
    //호스팅 메일서버 지정, properties 설정
    switch (HOST) {
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

  private static void sendEmail(EmailInfoDTO emailInfoDTO, String authKey, Properties props) {
    //권한 등록
    Session session = Session.getDefaultInstance(props, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(emailInfoDTO.getSendEmail(),
                                          emailInfoDTO.getPassword());
      }
    });

    //메일 작성
    try {
      Message message = new MimeMessage(session);

      message.setFrom(new InternetAddress(emailInfoDTO.getSendEmail()));
      message.addRecipient(Message.RecipientType.TO,
                           new InternetAddress(emailInfoDTO.getReceiveEmail()));

      message.setSubject("RecruTe 이메일 인증메일입니다.");
      String msgContent = "<h1>[이메일 인증]</h1>"
          + "<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>"
          + "<a href='http://localhost:8080/email?email="
          + emailInfoDTO.getReceiveEmail()
          + "&authKey="
          + authKey
          + "' target='_blank'>이메일 인증 확인</a>";
      message.setContent(msgContent, "text/html;charset=UTF-8");

//      Transport.send(message);

      System.out.println(
          "이메일 전송 성공 : " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss:SSS")));

    } catch (MessagingException e) {
      LOGGER.log(Level.SEVERE, Word.ERROR, e);
      System.out.println("이메일 전송 실패");
    }
  }

}