package com.blanc.recrute.exam.service;

import com.blanc.recrute.exam.dto.AptIdDTO;
import com.blanc.recrute.exam.dto.ExaminationDTO;
import com.blanc.recrute.exam.dto.RecruitIdDTO;
import com.blanc.recrute.exam.dto.RecruitInfoDTO;
import com.blanc.recrute.exam.dto.answer.AnswerData;
import com.blanc.recrute.member.dto.ValidationDTO;
import java.util.List;

public interface ExamService {

  default RecruitInfoDTO loadRecruitContentProcess(String aptId) {
    return null;
  }

  default ValidationDTO validateExamAuthEmail(String sessionAptId, AptIdDTO aptIdDTO) {
    return null;
  }

  default List<ExaminationDTO> loadExamination(Integer examId) {
    return null;
  }

  default ValidationDTO saveExamination(AnswerData answerData) {
    return null;
  }

  default ValidationDTO sendEmailToApplicant(RecruitIdDTO recruitIdDTO) {
    return null;
  }
}
