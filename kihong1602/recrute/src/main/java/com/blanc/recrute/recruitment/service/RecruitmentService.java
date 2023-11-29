package com.blanc.recrute.recruitment.service;

import com.blanc.recrute.member.dto.ValidationDTO;
import com.blanc.recrute.recruitment.dto.ApplyInfoDTO;
import com.blanc.recrute.recruitment.dto.DetailDTO;

public interface RecruitmentService {

  default DetailDTO findRecruitmentDetailInfo(Integer recruitId) {
    return null;
  }

  default ValidationDTO applyRecruitment(String memberId, ApplyInfoDTO applyInfoDTO) {
    return null;
  }
}
