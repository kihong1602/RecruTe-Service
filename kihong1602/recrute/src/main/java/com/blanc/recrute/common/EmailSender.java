package com.blanc.recrute.common;

import static com.blanc.recrute.common.Word.ERROR;
import static com.blanc.recrute.common.Word.FAIL;
import static com.blanc.recrute.common.Word.SUCCESS;

import com.blanc.recrute.member.dto.EmailInfoDTO;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailSender {

  private static final Logger LOGGER = Logger.getLogger(EmailSender.class.getName());
  private final Host HOST;

  public EmailSender(Host HOST) {
    this.HOST = HOST;
  }

  public Word mailSend(String receiveEmail, String title, String content) {
    EmailInfoDTO emailInfoDTO = new EmailInfoDTO(receiveEmail);
    Properties props = setProperties();

    return sendEmail(emailInfoDTO, title, content, props);
  }

  private Properties setProperties() {
    //호스팅 메일서버 지정, properties 설정
    switch (HOST) {
      case NAVER:
        String naver = "smtp.naver.com";

        Properties props = new Properties();
        props.put("mail.smtp.host", naver);
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");

        return props;
      case GOOGLE:
        String google = "smtp.gmail.com";

        props = new Properties();
        props.put("mail.smtp.host", google);
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.trust", HOST.getName());
        return props;
      default:
        return null;
    }

  }

  private Word sendEmail(EmailInfoDTO emailInfoDTO, String title, String content, Properties props) {
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

      message.setSubject(title);
      message.setText(content);
      message.setContent(content, "text/html;charset=UTF-8");

//      Transport.send(message);

      Thread.sleep(2);
    } catch (MessagingException | InterruptedException e) {
      LOGGER.log(Level.SEVERE, ERROR.value(), e);

      return FAIL;
    }
    return SUCCESS;
  }

}