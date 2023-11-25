package com.blanc.recrute.member.controller;

import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.member.dto.IdCheckDTO;
import com.blanc.recrute.member.dto.ValidationDTO;
import com.blanc.recrute.member.service.IdDuplicationCheckService;
import com.blanc.recrute.member.service.MemberService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "check-id", value = "/check-id")
public class IdCheckController extends HttpServlet {

  private final MemberService memberService = new IdDuplicationCheckService();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    IdCheckDTO idCheckDTO = JsonUtil.jsonParser(request, IdCheckDTO.class);

    ValidationDTO validationDTO = memberService.idCheck(idCheckDTO);

    JsonUtil.sendJSON(response, validationDTO);
  }
}
