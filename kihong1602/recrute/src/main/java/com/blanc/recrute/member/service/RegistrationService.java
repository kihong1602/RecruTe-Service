package com.blanc.recrute.member.service;

import static com.blanc.recrute.common.Count.ZERO;
import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.BLANK;
import static com.blanc.recrute.common.Word.EXIST;
import static com.blanc.recrute.common.Word.NONE;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dao.MenberDao;
import com.blanc.recrute.member.dto.IdCheckDTO;
import com.blanc.recrute.member.dto.MemberInfoDTO;
import com.blanc.recrute.member.dto.ValidationDTO;

public class RegistrationService {

  private final MenberDao menberDao = new MenberDao();


  public ValidationDTO memberRegistration(MemberInfoDTO memberDTO) {

    memberDTO.passwordEncoding();

    Integer result = menberDao.saveMember(memberDTO);

    return result > ZERO.getNumber() ? new ValidationDTO(AVAILABLE) : new ValidationDTO(UNAVAILABLE);
  }


  public ValidationDTO idDuplicateCheck(IdCheckDTO idCheckDTO) {
    String id = idCheckDTO.getMemberId();
    if (id == null || id.isEmpty()) {
      return new ValidationDTO(BLANK);
    }

    Word keyWord = checkResult(id);

    return switch (keyWord) {
      case EXIST -> new ValidationDTO(UNAVAILABLE);
      case NONE -> new ValidationDTO(AVAILABLE);
      default -> null;
    };
  }

  private Word checkResult(String id) {
    Integer result = menberDao.idCheck(id);
    return compareIdCheckResult(result);
  }

  private Word compareIdCheckResult(Integer result) {
    return result != null && result < 1 ? NONE : EXIST;
  }
}
