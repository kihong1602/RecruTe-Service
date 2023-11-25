package com.blanc.recrute.exam.controller;

import static com.blanc.recrute.common.TimeUnit.HOUR;
import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.FAIL;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.common.CookieManager;
import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.exam.dto.AptIdDTO;
import com.blanc.recrute.exam.dto.RecruitInfoDTO;
import com.blanc.recrute.exam.service.ExamService;
import com.blanc.recrute.member.dto.InvalidDTO;
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

  private final ExamService EXAM_SERVICE = new ExamService();
  private final String EXAM_AUTH = "examAuth";

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String aptId = request.getParameter("aptId");
    RecruitInfoDTO examDTO = EXAM_SERVICE.getRecruitContent(aptId);

    sendExamAuth(request, response, aptId);
    request.setAttribute("examDTO", examDTO);

    String path = "exam/exam-auth";
    ViewResolver.render(path, request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    AptIdDTO aptIdDTO = JsonUtil.jsonParser(request, AptIdDTO.class);

    Cookie examAuth = CookieManager.getCookie(request, EXAM_AUTH);

    InvalidDTO invalidDTO;
    if (examAuth != null) {

      String sessionAptId = CookieManager.getSessionValue(request, examAuth);
      invalidDTO = sessionAptId.equals(aptIdDTO.getAptId()) ? new InvalidDTO(AVAILABLE)
          : new InvalidDTO(UNAVAILABLE);

    } else {
      invalidDTO = new InvalidDTO(FAIL);
    }

    JsonUtil.sendJSON(response, invalidDTO);

  }


  private void sendExamAuth(HttpServletRequest request, HttpServletResponse response,
      String aptId) {
    HttpSession session = request.getSession();

    String uuid = String.valueOf(UUID.randomUUID());
    session.setAttribute(uuid, aptId);

    Cookie examAuthCookie = CookieManager.createCookie(EXAM_AUTH, uuid,
                                                       HOUR.getValue());
    response.addCookie(examAuthCookie);

  }
}


