package com.blanc.recrute.exam.controller;

import static com.blanc.recrute.common.TimeUnit.HOUR;

import com.blanc.recrute.common.CookieManager;
import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.exam.dto.AptIdDTO;
import com.blanc.recrute.exam.dto.RecruitInfoDTO;
import com.blanc.recrute.exam.service.ExamAuthService;
import com.blanc.recrute.member.dto.ValidationDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "exam", value = "/exam/auth/*")
public class ExamAuthController extends HttpServlet {

  private final ExamAuthService examService = new ExamAuthService();

  private static final String EXAM_AUTH = "examAuth";

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String aptId = request.getParameter("aptId");

    RecruitInfoDTO recruitInfoDTO = examService.loadRecruitContentProcess(aptId);

    setRecruitmentInfo(request, recruitInfoDTO);
    setExamAuthValue(request, response, aptId);

    String path = "exam/exam-auth";
    ViewResolver.render(path, request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    AptIdDTO aptIdDTO = JsonUtil.jsonParser(request, AptIdDTO.class);
    String sessionAptId = getSessionAptId(request);

    ValidationDTO validationDTO = examService.validateExamAuthEmail(sessionAptId, aptIdDTO);

    JsonUtil.sendJSON(response, validationDTO);
  }

  private void setRecruitmentInfo(HttpServletRequest request, RecruitInfoDTO recruitInfoDTO) {
    request.setAttribute("examDTO", recruitInfoDTO);
  }

  private void setExamAuthValue(HttpServletRequest request, HttpServletResponse response, String aptId) {
    HttpSession session = request.getSession();

    String uuid = String.valueOf(UUID.randomUUID());
    Cookie examAuthCookie = CookieManager.createCookie(EXAM_AUTH, uuid, HOUR.getValue());

    response.addCookie(examAuthCookie);
    session.setAttribute(uuid, aptId);
  }

  private String getSessionAptId(HttpServletRequest request) {
    Cookie requestCookie = CookieManager.getCookie(request, EXAM_AUTH);
    return CookieManager.getSessionValue(request, requestCookie);
  }

}


