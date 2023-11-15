package com.blanc.recrute.mybatis;

import com.blanc.recrute.recruitment.dto.ApplyDTO;
import com.blanc.recrute.recruitment.dto.DetailDTO;
import com.blanc.recrute.recruitment.dto.RecruitDTO;

public interface RecruitMapper {

  DetailDTO findRctDetailById(RecruitDTO recruitDTO);

  Integer findIdByMemberId(String memberId);

  int saveApply(ApplyDTO applyDTO);
}
