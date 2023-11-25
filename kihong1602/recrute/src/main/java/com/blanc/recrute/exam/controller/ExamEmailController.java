package com.blanc.recrute.exam.controller;

import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.exam.dto.RecruitIdDTO;
import com.blanc.recrute.exam.service.ExamService;
import com.blanc.recrute.member.dto.InvalidDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "exam/email", value = "/exam/email/*")
public class ExamEmailController extends HttpServlet {

  private final ExamService EXAM_SERVICE = new ExamService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String path = "exam/exam-email";
    ViewResolver.render(path, request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RecruitIdDTO recruitIdDTO = JsonUtil.jsonParser(request, RecruitIdDTO.class);

    String result = EXAM_SERVICE.sendEmailToApplicant(recruitIdDTO);

    InvalidDTO invalidDTO =
        result.equals(Word.SUCCESS.value()) ? new InvalidDTO(Word.AVAILABLE) : new InvalidDTO(Word.UNAVAILABLE);

    JsonUtil.sendJSON(response, invalidDTO);
  }
}
