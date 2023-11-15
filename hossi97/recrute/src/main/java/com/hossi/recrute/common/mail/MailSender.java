package com.hossi.recrute.common.mail;

import com.hossi.recrute.common.mybatis.ResultType;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import static com.hossi.recrute.common.mybatis.ResultType.FAILURE;
import static com.hossi.recrute.common.mybatis.ResultType.SUCCESS;

public class MailSender {
    private final MailInfo mailInfo;

    public MailSender(MailType mailType) {
        mailInfo = MailConfig.getMailInfo(mailType);
    }

    public ResultType sendEmail(String userEmail, String title, String content) {
        Properties props = new Properties();
        props.put("mail.smtp.host", mailInfo.getHost());
        props.put("mail.smtp.port", mailInfo.getPort());
        props.put("mail.smtp.auth", mailInfo.getAuth());
        props.put("mail.smtp.ssl.enable", mailInfo.getEnable());
        props.put("mail.smtp.ssl.trust", mailInfo.getTrust());

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(mailInfo.getEmail(), mailInfo.getPassword());
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(mailInfo.getEmail(), "Recrute-Team"));
            msg.addRecipient(Message.RecipientType.TO,
                new InternetAddress(userEmail, "Mr. User"));
            msg.setSubject(title);
            msg.setText(content);
            msg.setContent(content, "text/html;charset=UTF-8");

            Transport.send(msg);

            return SUCCESS;
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return FAILURE;
        }
    }
}
