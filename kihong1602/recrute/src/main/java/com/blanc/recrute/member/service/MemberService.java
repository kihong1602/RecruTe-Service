package com.blanc.recrute.member.service;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dto.IdCheckDTO;
import com.blanc.recrute.member.dto.LoginDTO;
import com.blanc.recrute.member.dto.MemberInfoDTO;
import com.blanc.recrute.member.dto.ValidationDTO;

public interface MemberService {

  default ValidationDTO memberRegistration(MemberInfoDTO memberDTO) {
    return null;
  }

  default ValidationDTO idCheck(IdCheckDTO idCheckDTO) {
    return null;
  }

  default ValidationDTO loginCheck(LoginDTO loginDTO) {
    return null;
  }

  default ValidationDTO sendAuthEmail(String memberId, String authKey) {
    return null;
  }

  default Word authGrantMember(boolean authKeyValidationResult, String email) {
    return null;
  }
}
