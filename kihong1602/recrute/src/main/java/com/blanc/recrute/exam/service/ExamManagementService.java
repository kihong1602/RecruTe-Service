package com.blanc.recrute.exam.service;

import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.exam.dao.ExamDao;
import com.blanc.recrute.exam.dto.ExaminationDTO;
import com.blanc.recrute.exam.dto.answer.AnswerData;
import com.blanc.recrute.member.dto.ValidationDTO;
import java.util.List;

public class ExamManagementService {

  private final ExamDao examDAO = new ExamDao();


  public List<ExaminationDTO> loadExamination(Integer examId) {
    Integer recruitId = findRecruitId(examId);

    return examDAO.getExamination(recruitId);
  }

  private Integer findRecruitId(Integer examId) {
    Integer recruitId = examDAO.getRecruitId(examId);
    if (recruitId != null) {
      return recruitId;
    } else {
      throw new NullPointerException("존재하지않는 채용공고 또는 시험 입니다.");
    }
  }

  public ValidationDTO saveExamination(AnswerData answerData) {
    String saveResult = examDAO.saveExamination(answerData);
    return saveResult != null ? new ValidationDTO(AVAILABLE) : new ValidationDTO(UNAVAILABLE);
  }

}
