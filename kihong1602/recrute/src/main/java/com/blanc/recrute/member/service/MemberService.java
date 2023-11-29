package com.blanc.recrute.member.service;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dto.ConfirmValueDTO;
import com.blanc.recrute.member.dto.IdCheckDTO;
import com.blanc.recrute.member.dto.LoginDTO;
import com.blanc.recrute.member.dto.MemberInfoDTO;
import com.blanc.recrute.member.dto.ValidationDTO;
import jakarta.servlet.http.HttpServletRequest;

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

  default ValidationDTO sendAuthEmail(HttpServletRequest request, ConfirmValueDTO confirmValueDTO) {
    return null;
  }

  default Word authGrantMember(HttpServletRequest request, String email) {
    return null;
  }
}
