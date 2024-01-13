package com.blanc.recrute.recruitment.service;

import static com.blanc.recrute.common.Count.ZERO;
import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.common.util.AptIdCreator;
import com.blanc.recrute.member.dto.ValidationDTO;
import com.blanc.recrute.recruitment.dao.RecruitDao;
import com.blanc.recrute.recruitment.dto.ApplyDTO;
import com.blanc.recrute.recruitment.dto.ApplyInfoDTO;
import com.blanc.recrute.recruitment.dto.DetailDTO;
import com.blanc.recrute.recruitment.dto.RecruitDTO;

public class RecruitmentService {

  private final RecruitDao recruitDAO = new RecruitDao();


  public ValidationDTO applyRecruitment(String memberId, ApplyInfoDTO applyInfoDTO) {
    Integer memberPk = recruitDAO.findMemberPk(memberId);
    String aptId = AptIdCreator.createAptId();

    return applyProcess(applyInfoDTO, aptId, memberPk);
  }

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
