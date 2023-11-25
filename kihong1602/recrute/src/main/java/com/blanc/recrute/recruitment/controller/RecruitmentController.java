package com.blanc.recrute.recruitment.controller;

import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.member.dto.ValidationDTO;
import com.blanc.recrute.recruitment.dto.ApplyInfoDTO;
import com.blanc.recrute.recruitment.service.RecruitmentApplicationService;
import com.blanc.recrute.recruitment.service.RecruitmentDetailService;
import com.blanc.recrute.recruitment.service.RecruitmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RecruitController", value = "/recruitments/*")
public class RecruitmentController extends HttpServlet {

  private RecruitmentService recruitmentService;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    recruitmentService = new RecruitmentDetailService();

    recruitmentService.findRecruitmentDetailInfo(request);

    String path = "recruitment/rct-detail";
    ViewResolver.render(path, request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    recruitmentService = new RecruitmentApplicationService();
    ApplyInfoDTO applyInfoDTO = JsonUtil.jsonParser(request, ApplyInfoDTO.class);

    ValidationDTO validationDTO = recruitmentService.applyRecruitment(request, applyInfoDTO);

    JsonUtil.sendJSON(response, validationDTO);
  }
}
