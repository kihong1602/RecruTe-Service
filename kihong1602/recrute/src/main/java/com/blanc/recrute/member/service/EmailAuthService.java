package com.blanc.recrute.member.service;

import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.FAIL;
import static com.blanc.recrute.common.Word.SUCCESS;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.common.email.EmailService;
import com.blanc.recrute.member.dao.MenberDao;
import com.blanc.recrute.member.dto.MemberDTO;
import com.blanc.recrute.member.dto.ValidationDTO;

public class EmailAuthService {

  private final MenberDao menberDao = new MenberDao();
  private final EmailService emailService = new EmailService();


  public ValidationDTO sendAuthEmail(String memberId, String authKey) {

    MemberDTO inputMemberId = new MemberDTO.Builder().memberId(memberId)
                                                     .build();

    String savedEmail = menberDao.findEmail(inputMemberId);

    emailSendProcess(savedEmail, authKey);

    return new ValidationDTO(AVAILABLE);
  }


  public Word authGrantMember(boolean authKeyValidationResult, String email) {

    Word result = memberAuthProcess(email, authKeyValidationResult);

    return result == null ? SUCCESS : FAIL;
  }

  private void emailSendProcess(String savedEmail, String authKey) {
    if (savedEmail != null) {
      emailService.sendMemberAuthEmail(savedEmail, authKey);
    } else {
      throw new NullPointerException("이메일이 존재하지않습니다.");
    }
  }


  private Word memberAuthProcess(String email, boolean authKeyValidationResult) {
    if (authKeyValidationResult) {
      Integer result = menberDao.memberAuthentication(new MemberDTO.Builder().email(email)
                                                                             .build());
      if (result == null) {
        return FAIL;
      }

    } else {
      return FAIL;
    }
    return null;
  }
}
