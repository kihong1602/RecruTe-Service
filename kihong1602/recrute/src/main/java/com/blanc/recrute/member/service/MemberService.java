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
    throw new UnsupportedOperationException("Not implemented in the base interface");
  }

  default ValidationDTO idCheck(IdCheckDTO idCheckDTO) {
    throw new UnsupportedOperationException("Not implemented in the base interface");
  }

  default ValidationDTO loginCheck(LoginDTO loginDTO) {
    throw new UnsupportedOperationException("Not implemented in the base interface");
  }

  default ValidationDTO sendAuthEmail(HttpServletRequest request, ConfirmValueDTO confirmValueDTO) {
    throw new UnsupportedOperationException("Not implemented in the base interface");
  }

  default Word authGrantMember(HttpServletRequest request, String email) {
    throw new UnsupportedOperationException("Not implemented in the base interface");
  }
}
