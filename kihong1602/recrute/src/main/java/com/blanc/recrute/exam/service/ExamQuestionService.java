package com.blanc.recrute.exam.service;

import com.blanc.recrute.exam.dao.ExamDAO;
import com.blanc.recrute.exam.dto.ExaminationDTO;
import java.util.List;

public class ExamQuestionService implements ExamService {

  private final ExamDAO examDAO = new ExamDAO();

  @Override
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

}
