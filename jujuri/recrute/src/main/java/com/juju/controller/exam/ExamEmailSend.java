package com.juju.controller.exam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.juju.dao.ApplicantDao;
import com.juju.dao.MemberDao;
import com.juju.dto.MemberDto;
import com.juju.util.EmailManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExamEmailSend extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ExamEmailSend() {}

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String recruitmentId = request.getParameter("recruitmentId");
    ApplicantDao applicantDao = new ApplicantDao();
    int count = applicantDao.countApplicant(recruitmentId);

    MemberDao memberDao = new MemberDao();
    List<MemberDto> emailList = new ArrayList<>();
    emailList = memberDao.getEmails(recruitmentId);

    for (int i = 0; i < count; i++) {
      System.out.println(emailList.get(i).getEmail());
      String email = emailList.get(i).getEmail();
      // EmailSendAsync 클래스 만들어서 여기에다가 아래코드 넣기... 말이 안되는데?
      CompletableFuture.runAsync(() -> {
        EmailManager.mailSend("naver", email, "시험 응시하기",
            "<a href='http://localhost:8080/recrute/exam/1/auth'>여기를 클릭하시면 시험페이지로 이동합니다.</a>");
      });
    }

  }



}
