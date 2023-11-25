package com.blanc.recrute.recruitment.service;

import com.blanc.recrute.member.dto.ValidationDTO;
import com.blanc.recrute.recruitment.dto.ApplyInfoDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface RecruitmentService {

  default void findRecruitmentDetailInfo(HttpServletRequest request) {
    throw new UnsupportedOperationException("Not implemented in the base interface");
  }

  default ValidationDTO applyRecruitment(HttpServletRequest request, ApplyInfoDTO applyInfoDTO) {
    throw new UnsupportedOperationException("Not implemented in the base interface");
  }
}
