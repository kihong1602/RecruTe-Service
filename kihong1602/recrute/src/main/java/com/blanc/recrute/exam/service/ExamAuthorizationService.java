package com.blanc.recrute.exam.service;

import static com.blanc.recrute.common.TimeUnit.HOUR;
import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.FAIL;
import static com.blanc.recrute.common.Word.SUCCESS;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.common.CookieManager;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.exam.dao.ExamDAO;
import com.blanc.recrute.exam.dto.AptIdDTO;
import com.blanc.recrute.exam.dto.RecruitInfoDTO;
import com.blanc.recrute.member.dto.ValidationDTO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.UUID;

public class ExamAuthorizationService implements ExamService {

  private final ExamDAO examDAO = new ExamDAO();

  private static final String EXAM_AUTH = "examAuth";

  @Override
  public void loadRecruitContentProcess(HttpServletRequest request, HttpServletResponse response) {
    String aptId = request.getParameter("aptId");

    RecruitInfoDTO recruitInfoDTO = examDAO.getRecruitContent(aptId);
    if (recruitInfoDTO != null) {
      setRecruitmentInfo(request, recruitInfoDTO);
      setExamAuthValue(request, response, aptId);
    } else {
      throw new NullPointerException("시험정보가 존재하지 않습니다.");
    }

  }

  @Override
  public ValidationDTO validateExamAuthEmail(HttpServletRequest request, AptIdDTO aptIdDTO) {
    Cookie requestAuthCookie = CookieManager.getCookie(request, EXAM_AUTH);

    if (requestAuthCookie != null) {
      String sessionAptId = CookieManager.getSessionValue(request, requestAuthCookie);
      boolean compareResult = compareAptId(sessionAptId, aptIdDTO);
      return validationAptId(compareResult, aptIdDTO);
    } else {
      return new ValidationDTO(FAIL);
    }
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

  private boolean compareAptId(String sessionAptId, AptIdDTO aptIdDTO) {
    return sessionAptId.equals(aptIdDTO.getAptId());
  }

  private ValidationDTO validationAptId(boolean compareResult, AptIdDTO aptIdDTO) {
    if (compareResult) {
      Word result = examDAO.validationAptId(aptIdDTO.getAptId());
      return result.equals(SUCCESS) ? new ValidationDTO(AVAILABLE) : new ValidationDTO(FAIL);
    } else {
      return new ValidationDTO(UNAVAILABLE);
    }
  }
}
