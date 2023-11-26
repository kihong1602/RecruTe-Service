package com.blanc.recrute.exam.service;

import com.blanc.recrute.common.URLParser;
import com.blanc.recrute.exam.dao.ExamDAO;
import com.blanc.recrute.exam.dto.ExaminationDTO;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class ExamQuestionService implements ExamService {

  private final ExamDAO examDAO = new ExamDAO();

  @Override
  public void loadExamination(HttpServletRequest request) {
    Integer recruitId = findRecruitId(request);

    List<ExaminationDTO> examList = examDAO.getExamination(recruitId);
    request.setAttribute("ExamList", examList);
    request.setAttribute("size", examList.size());
  }

  private Integer findRecruitId(HttpServletRequest request) {
    Integer examId = URLParser.getLastURI(request);
    Integer recruitId = examDAO.getRecruitId(examId);
    if (recruitId != null) {
      return recruitId;
    } else {
      throw new NullPointerException("존재하지않는 채용공고 또는 시험 입니다.");
    }
  }

}
