package com.blanc.recrute.member.controller;

import com.blanc.recrute.common.util.JsonUtil;
import com.blanc.recrute.member.dto.IdCheckDTO;
import com.blanc.recrute.member.dto.ValidationDTO;
import com.blanc.recrute.member.service.RegistrationService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "check-id", value = "/check-id")
public class IdCheckServlet extends HttpServlet {

  private final RegistrationService memberService = new RegistrationService();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    IdCheckDTO idCheckDTO = JsonUtil.jsonParser(request, IdCheckDTO.class);

    ValidationDTO validationDTO = memberService.idDuplicateCheck(idCheckDTO);

    JsonUtil.sendJSON(response, validationDTO);
  }
}
