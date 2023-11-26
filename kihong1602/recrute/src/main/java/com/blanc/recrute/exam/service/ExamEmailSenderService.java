package com.blanc.recrute.exam.service;

import com.blanc.recrute.common.EmailService;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.exam.dao.ExamDAO;
import com.blanc.recrute.exam.dto.ApplicantUserInfo;
import com.blanc.recrute.exam.dto.RecruitIdDTO;
import com.blanc.recrute.member.dto.ValidationDTO;
import java.util.List;

public class ExamEmailSenderService implements ExamService {

  private final ExamDAO examDAO = new ExamDAO();
  private final EmailService emailService = new EmailService();

  @Override
  public ValidationDTO sendEmailToApplicant(RecruitIdDTO recruitIdDTO) {
    final String SYNC = "sync";
    final String ASYNC = "async";

    List<ApplicantUserInfo> applicantUserInfoList = examDAO.getEmailList(recruitIdDTO);
    String result = emailService.examAuthEmailAdapter(ASYNC, applicantUserInfoList, recruitIdDTO.getRecruitId());

    return result.equals(Word.SUCCESS.value()) ? new ValidationDTO(Word.AVAILABLE)
        : new ValidationDTO(Word.UNAVAILABLE);
  }
}
