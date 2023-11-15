package com.juju.member.controller;

import java.io.IOException;
import java.time.LocalDate;
import com.juju.common.ScriptWriter;
import com.juju.member.dao.MemberDao;
import com.juju.member.dto.MemberDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignUpProcess extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public SignUpProcess() {
    super();

  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String userId = request.getParameter("userId");
    String pw = request.getParameter("pw");
    String username = request.getParameter("username");
    LocalDate birth = LocalDate.parse(request.getParameter("birth"));
    String phoneNum = request.getParameter("phoneNum");
    int gender = Integer.parseInt(request.getParameter("gender"));
    String email = request.getParameter("email");

    System.out.println(gender);


    MemberDto memberDto = new MemberDto();
    memberDto.setMember_id(userId);
    memberDto.setPassword(pw);
    memberDto.setName(username);
    memberDto.setBirth(birth);
    memberDto.setPhone_number(phoneNum);
    memberDto.setEmail(email);
    memberDto.setGender(gender);

    MemberDao memberDao = new MemberDao();
    int result = memberDao.insertMember(memberDto);
    if (result > 0) {
      ScriptWriter.alertAndNext(response, "signup succeeded", "/recrute/index");
    } else {
      ScriptWriter.alertAndBack(response, "signup failed");
    }
  }
}
