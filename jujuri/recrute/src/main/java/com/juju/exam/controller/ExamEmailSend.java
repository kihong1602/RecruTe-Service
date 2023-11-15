package com.juju.exam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.juju.common.EmailManager;
import com.juju.hire.dao.ApplicantDao;
import com.juju.member.dao.MemberDao;
import com.juju.member.dto.MemberDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExamEmailSend extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ExamEmailSend() {}

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    long beforeTime = System.currentTimeMillis();
    String recruitmentId = request.getParameter("recruitmentId");
    ApplicantDao applicantDao = new ApplicantDao();
    int count = applicantDao.countApplicant(recruitmentId);

    MemberDao memberDao = new MemberDao();
    List<MemberDto> emailList = new ArrayList<>();
    emailList = memberDao.getEmails(recruitmentId);
    long runTime = 0;

    for (int i = 0; i < count; i++) {
      String email = emailList.get(i).getEmail();
      CompletableFuture.runAsync(() -> {
        EmailManager.mailSend("naver", email, "시험 응시하기",
            "<a href='http://localhost:8080/recrute/exam/auth'>여기를 클릭하시면 시험페이지로 이동합니다.</a>");
      }); // 비동기 처리



      /*
       * EmailManager.mailSend("naver", email, "시험 응시하기",
       * "<a href='http://localhost:8080/recrute/exam/auth'>여기를 클릭하시면 시험페이지로 이동합니다.</a>");
       */

    }
    long afterTime = System.currentTimeMillis();
    runTime = afterTime - beforeTime;
    System.out.println("runtime===" + runTime);

  }



}
