package com.blanc.recrute.recruitment.service;

import com.blanc.recrute.common.AptIdFactory;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.recruitment.dao.RecruitDAO;
import com.blanc.recrute.recruitment.dto.ApplyDTO;
import com.blanc.recrute.recruitment.dto.ApplyInfoDTO;
import com.blanc.recrute.recruitment.dto.DetailDTO;
import com.blanc.recrute.recruitment.dto.RecruitDTO;

public class RecruitService {

  private final RecruitDAO RECRUIT_DAO = new RecruitDAO();
  private final int NONE = 0;

  public DetailDTO findRctDetail(Integer id) {

    if (id != null) {
      RecruitDTO recruitDTO = new RecruitDTO.Builder().id(id).build();

      return RECRUIT_DAO.findRctDetail(recruitDTO);
    }

    return null;
  }

  public String apply(ApplyInfoDTO applyInfoDTO, String memberId) {

    Integer memberRealId = RECRUIT_DAO.findMemberId(memberId);

    String aptId = AptIdFactory.createAptId();

    ApplyDTO applyDto = new ApplyDTO.Builder().aptId(aptId).recruitId(applyInfoDTO.getRecruitId())
                                              .memberId(memberRealId).build();
    int result = RECRUIT_DAO.apply(applyDto);

    return result > NONE ? Word.SUCCESS : Word.FAIL;
  }
}
