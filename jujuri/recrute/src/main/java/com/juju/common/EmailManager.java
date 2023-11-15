package com.juju.common;


import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailManager {

  public static boolean mailSend(String hostName, String receiveEmail, String title, String msg) {

    Properties props = setProperties(hostName);
    boolean result = props != null && sendEmail(receiveEmail, props, title, msg);

    return result;
  }

  private static Properties setProperties(String hostName) {
    // 호스팅 메일서버 지정, properties 설정
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

  private static boolean sendEmail(String receiveEmail, Properties props, String title,
      String msg) {
    // 권한 등록
    Session session = Session.getDefaultInstance(props, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("0612000ljy@naver.com", "fuxxit:3");
      }
    });

    // 메일 작성
    try {
      Message message = new MimeMessage(session);

      message.setFrom(new InternetAddress("0612000ljy@naver.com"));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiveEmail));

      message.setSubject(title);
      message.setText(msg);

      message.setContent(msg, "text/html;charset=UTF-8");
      Transport.send(message);

    } catch (MessagingException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

}
