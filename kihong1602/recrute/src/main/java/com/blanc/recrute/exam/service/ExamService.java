package com.blanc.recrute.exam.service;

import com.blanc.recrute.exam.dto.AptIdDTO;
import com.blanc.recrute.exam.dto.RecruitIdDTO;
import com.blanc.recrute.exam.dto.answer.AnswerData;
import com.blanc.recrute.member.dto.ValidationDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ExamService {

  default void loadRecruitContentProcess(HttpServletRequest request, HttpServletResponse response) {
    throw new UnsupportedOperationException("지원하지 않는 기능입니다.");
  }

  default ValidationDTO validateExamAuthEmail(HttpServletRequest request, AptIdDTO aptIdDTO) {
    return null;
  }

  default void loadExamination(HttpServletRequest request) {
    throw new UnsupportedOperationException("지원하지 않는 기능입니다.");
  }

  default ValidationDTO saveExamination(AnswerData answerData) {
    return null;
  }

  default ValidationDTO sendEmailToApplicant(RecruitIdDTO recruitIdDTO) {
    return null;
  }
}
