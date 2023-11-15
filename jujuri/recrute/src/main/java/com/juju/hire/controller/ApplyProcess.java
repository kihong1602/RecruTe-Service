package com.juju.hire.controller;

import java.io.IOException;
import com.juju.common.MakeRandomCode;
import com.juju.common.ScriptWriter;
import com.juju.hire.dao.ApplicantDao;
import com.juju.hire.dto.ApplicantDto;
import com.juju.member.dao.MemberDao;
import com.juju.member.dto.MemberDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ApplyProcess extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public ApplyProcess() {
    super();
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    String userId = (String) session.getAttribute("loggedID");
    int rctId = Integer.parseInt(request.getParameter("id"));
    String aptId = "RCT" + MakeRandomCode.randomNum(8);

    MemberDao memberDao = new MemberDao();
    MemberDto memberDto = memberDao.findMember(userId);

    int memberId = memberDto.getId();

    ApplicantDao applicantDao = new ApplicantDao();
    ApplicantDto applicantDto = new ApplicantDto();
    applicantDto.setMember_id(memberId);
    applicantDto.setRecruitment_id(rctId);
    applicantDto.setApt_id(aptId);

    int result = applicantDao.insertApplicant(applicantDto);
    if (result > 0) {
      ScriptWriter.alertAndNext(response, "applied to the company successfully",
          "/recrute/recruit?recruitId=" + rctId);
    } else {
      ScriptWriter.alertAndBack(response, "please try it agian");
    }
  }

}
