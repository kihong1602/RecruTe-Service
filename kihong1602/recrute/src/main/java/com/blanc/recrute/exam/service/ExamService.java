package com.blanc.recrute.exam.service;

import com.blanc.recrute.exam.dto.AptIdDTO;
import com.blanc.recrute.exam.dto.RecruitIdDTO;
import com.blanc.recrute.exam.dto.answer.AnswerData;
import com.blanc.recrute.member.dto.ValidationDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ExamService {

  default void loadRecruitContentProcess(HttpServletRequest request, HttpServletResponse response) {
    throw new UnsupportedOperationException("Not implemented in the base interface");
  }

  default ValidationDTO validateExamAuthEmail(HttpServletRequest request, AptIdDTO aptIdDTO) {
    throw new UnsupportedOperationException("Not implemented in the base interface");
  }

  default void loadExamination(HttpServletRequest request) {
    throw new UnsupportedOperationException("Not implemented in the base interface");
  }

  default ValidationDTO saveExamination(AnswerData answerData) {
    throw new UnsupportedOperationException("Not implemented in the base interface");
  }

  default ValidationDTO sendEmailToApplicant(RecruitIdDTO recruitIdDTO) {
    throw new UnsupportedOperationException("Not implemented in the base interface");
  }
}
