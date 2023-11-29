package com.blanc.recrute.recruitment.service;

import com.blanc.recrute.member.dto.ValidationDTO;
import com.blanc.recrute.recruitment.dto.ApplyInfoDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface RecruitmentService {

  default void findRecruitmentDetailInfo(HttpServletRequest request) {
    throw new UnsupportedOperationException("지원하지 않는 기능입니다.");
  }

  default ValidationDTO applyRecruitment(HttpServletRequest request, ApplyInfoDTO applyInfoDTO) {
    return null;
  }
}
