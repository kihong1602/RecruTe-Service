package com.juju.controller.hire;

import java.io.IOException;
import com.juju.dao.ApplicantDao;
import com.juju.dao.MemberDao;
import com.juju.dto.ApplicantDto;
import com.juju.dto.MemberDto;
import com.juju.util.MakeRandomCode;
import com.juju.util.ScriptWriter;
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
    // loggedID => 해당 멤버 찾아와서 새로운 dto생성
    // member_id fk from member table
    // aptid = 수험번호 내가 임의로 지정함
    // rct_id = recruitment에서 가져옴
    HttpSession session = request.getSession();
    String userId = (String) session.getAttribute("loggedID");
    int rctId = Integer.parseInt(request.getParameter("id"));
    String aptId = "RCT" + MakeRandomCode.randomNum(8);
    System.out.println("rctId===" + rctId);
    MemberDao memberDao = new MemberDao();
    MemberDto memberDto = memberDao.findMember(userId);
    // System.out.println(memberDto.toString());
    int memberId = memberDto.getId();

    ApplicantDao applicantDao = new ApplicantDao();
    ApplicantDto applicantDto = new ApplicantDto();
    applicantDto.setMember_id(memberId);
    applicantDto.setRecruitment_id(rctId);
    applicantDto.setApt_id(aptId);
    // 같은 사용자가 여러 번을 지원하면 데베에 중복입력이 가능함 -> 이 문제 고칠 것
    int result = applicantDao.insertApplicant(applicantDto);
    if (result > 0) {
      ScriptWriter.alertAndNext(response, "applied to the company successfully",
          "/recrute/recruit?recruitId=" + rctId);
    } else {
      ScriptWriter.alertAndBack(response, "please try it agian");
    }
  }

}
