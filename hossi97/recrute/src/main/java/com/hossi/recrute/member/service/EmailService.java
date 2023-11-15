package com.hossi.recrute.member.service;

import com.hossi.recrute.common.mail.MailSender;
import com.hossi.recrute.common.mybatis.ResultType;
import com.hossi.recrute.member.dao.MemberDao;

import static com.hossi.recrute.common.mail.MailType.GOOGLE;

public class EmailService {
    private static final MemberDao memberDao = new MemberDao();
    private static final MailSender gmailSender = new MailSender(GOOGLE);
    private static final String EMAIL_AUTH_URL = "localhost:8080/member/email/auth?code=";
    private static final String TITLE = "RecruTe 서비스 이메일 인증";
    private static final String CONTENT = "<p>이메일 인증을 위해 다음 링크를 클릭해주세요: ";

    public ResultType sendEmail(Integer id, String code) {
        String userEmail = getEmail(id);
        String content = CONTENT + "<a href=\"" + EMAIL_AUTH_URL + code + "\">인증하기</a></p>";
        return gmailSender.sendEmail(userEmail, TITLE, content);
    }

    private String getEmail(Integer id) {
        return memberDao.findEmail(id);
    }
}
