package com.blanc.recrute.exam.service;

import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.exam.dao.ExamDAO;
import com.blanc.recrute.exam.dto.answer.AnswerData;
import com.blanc.recrute.member.dto.ValidationDTO;

public class ExamSubmissionService implements ExamService {

  private final ExamDAO examDAO = new ExamDAO();

  @Override
  public ValidationDTO saveExamination(AnswerData answerData) {
    String saveResult = examDAO.saveExamination(answerData);
    return saveResult != null ? new ValidationDTO(AVAILABLE) : new ValidationDTO(UNAVAILABLE);
  }
}
