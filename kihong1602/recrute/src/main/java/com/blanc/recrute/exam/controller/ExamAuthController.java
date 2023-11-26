package com.blanc.recrute.exam.controller;

import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.exam.dto.AptIdDTO;
import com.blanc.recrute.exam.service.ExamAuthorizationService;
import com.blanc.recrute.exam.service.ExamService;
import com.blanc.recrute.member.dto.ValidationDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "exam", value = "/exam/auth/*")
public class ExamAuthController extends HttpServlet {

  private final ExamService examService = new ExamAuthorizationService();


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    examService.loadRecruitContentProcess(request, response);

    String path = "exam/exam-auth";
    ViewResolver.render(path, request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    AptIdDTO aptIdDTO = JsonUtil.jsonParser(request, AptIdDTO.class);

    ValidationDTO validationDTO = examService.validateExamAuthEmail(request, aptIdDTO);

    JsonUtil.sendJSON(response, validationDTO);
  }
}


