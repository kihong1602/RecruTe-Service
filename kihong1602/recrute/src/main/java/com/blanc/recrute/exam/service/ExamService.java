package com.blanc.recrute.exam.service;

import static com.blanc.recrute.common.Word.FAIL;
import static com.blanc.recrute.common.Word.SUCCESS;

import com.blanc.recrute.common.EmailService;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.exam.dao.ExamDAO;
import com.blanc.recrute.exam.dto.ExaminationDTO;
import com.blanc.recrute.exam.dto.RecruitIdDTO;
import com.blanc.recrute.exam.dto.RecruitInfoDTO;
import com.blanc.recrute.exam.dto.answer.AnswerData;
import java.util.List;

public class ExamService {

  private final ExamDAO EXAM_DAO = new ExamDAO();
  private final EmailService emailService = new EmailService();

  public RecruitInfoDTO getRecruitContent(String aptId) {

    return aptId != null ? EXAM_DAO.getRecruitContent(aptId) : null;

  }

  public List<ExaminationDTO> getExamination(Integer examId) {
    Integer recruitId = EXAM_DAO.getRecruitId(examId);

    return EXAM_DAO.getExamination(recruitId);
  }

  public Word saveExamination(AnswerData answerData) {

    return EXAM_DAO.saveExamination(answerData) != null ? SUCCESS : FAIL;
  }

  public String sendEmailToApplicant(RecruitIdDTO recruitIdDTO) {

    List<String> emailList = EXAM_DAO.getEmailList(recruitIdDTO);

    return emailService.SendExamAuthEmail(emailList, recruitIdDTO);
  }

}
