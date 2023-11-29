package com.blanc.recrute.recruitment.service;

import static com.blanc.recrute.common.Count.ZERO;
import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.common.AptIdFactory;
import com.blanc.recrute.member.dto.ValidationDTO;
import com.blanc.recrute.recruitment.dao.RecruitDAO;
import com.blanc.recrute.recruitment.dto.ApplyDTO;
import com.blanc.recrute.recruitment.dto.ApplyInfoDTO;

public class RecruitmentApplicationService implements RecruitmentService {

  private final RecruitDAO recruitDAO = new RecruitDAO();

  @Override
  public ValidationDTO applyRecruitment(String memberId, ApplyInfoDTO applyInfoDTO) {
    Integer memberPk = recruitDAO.findMemberPk(memberId);
    String aptId = AptIdFactory.createAptId();

    return applyProcess(applyInfoDTO, aptId, memberPk);
  }

  private ValidationDTO applyProcess(ApplyInfoDTO applyInfoDTO, String aptId, Integer memberPk) {
    ApplyDTO applyDto = new ApplyDTO.Builder().aptId(aptId)
                                              .recruitId(applyInfoDTO.getRecruitId())
                                              .memberId(memberPk)
                                              .build();
    Integer result = recruitDAO.apply(applyDto);

    return result != null && result > ZERO.getNumber() ? new ValidationDTO(AVAILABLE)
        : new ValidationDTO(UNAVAILABLE);
  }

}
