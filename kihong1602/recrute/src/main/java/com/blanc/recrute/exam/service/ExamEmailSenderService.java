package com.blanc.recrute.exam.service;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.common.email.EmailService;
import com.blanc.recrute.exam.dao.ExamDao;
import com.blanc.recrute.exam.dto.ApplicantUserInfo;
import com.blanc.recrute.exam.dto.RecruitIdDTO;
import com.blanc.recrute.member.dto.ValidationDTO;
import java.util.List;

public class ExamEmailSenderService {

  private final ExamDao examDAO = new ExamDao();
  private final EmailService emailService = new EmailService();


  public ValidationDTO sendEmailToApplicant(RecruitIdDTO recruitIdDTO) {

    List<ApplicantUserInfo> applicantUserInfoList = examDAO.getEmailList(recruitIdDTO);
    String result = emailService.sendExamAuthEmail(applicantUserInfoList, recruitIdDTO.getRecruitId());

    return result.equals(Word.SUCCESS.value()) ? new ValidationDTO(Word.AVAILABLE)
        : new ValidationDTO(Word.UNAVAILABLE);
  }
}
