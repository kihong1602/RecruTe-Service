package com.blanc.recrute.recruitment.service;

import com.blanc.recrute.recruitment.dao.RecruitDAO;
import com.blanc.recrute.recruitment.dto.DetailDTO;
import com.blanc.recrute.recruitment.dto.RecruitDTO;

public class RecruitmentDetailService implements RecruitmentService {

  private final RecruitDAO recruitDAO = new RecruitDAO();

  @Override
  public DetailDTO findRecruitmentDetailInfo(Integer recruitId) {
    if (recruitId != null) {
      RecruitDTO recruitDTO = new RecruitDTO.Builder().id(recruitId)
                                                      .build();

      DetailDTO detailDTO = recruitDAO.findRctDetail(recruitDTO);

      if (detailDTO != null) {
        return detailDTO;
      } else {
        throw new NullPointerException("채용공고가 존재하지 않거나 잘못된 채용공고 번호입니다.");
      }

    } else {
      throw new NullPointerException("올바르지않은 채용공고 번호입니다.");
    }
  }
}
