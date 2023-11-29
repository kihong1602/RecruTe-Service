package com.blanc.recrute.exam.service;

import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.FAIL;
import static com.blanc.recrute.common.Word.SUCCESS;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.exam.dao.ExamDAO;
import com.blanc.recrute.exam.dto.AptIdDTO;
import com.blanc.recrute.exam.dto.RecruitInfoDTO;
import com.blanc.recrute.member.dto.ValidationDTO;

public class ExamAuthService {

  private final ExamDAO examDAO = new ExamDAO();


  public RecruitInfoDTO loadRecruitContentProcess(String aptId) {

    RecruitInfoDTO recruitInfoDTO = examDAO.getRecruitContent(aptId);
    if (recruitInfoDTO != null) {
      return recruitInfoDTO;
    } else {
      throw new NullPointerException("시험정보가 존재하지 않습니다.");
    }

  }


  public ValidationDTO validateExamAuthEmail(String sessionAptId, AptIdDTO aptIdDTO) {

    if (sessionAptId != null) {
      boolean compareResult = compareAptId(sessionAptId, aptIdDTO);
      return validationAptId(compareResult, aptIdDTO);
    } else {
      return new ValidationDTO(FAIL);
    }
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
