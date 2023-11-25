package com.blanc.recrute.member.service;

import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.BLANK;
import static com.blanc.recrute.common.Word.EXIST;
import static com.blanc.recrute.common.Word.NONE;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dao.MemberDAO;
import com.blanc.recrute.member.dto.IdCheckDTO;
import com.blanc.recrute.member.dto.ValidationDTO;

public class IdDuplicationCheckService implements MemberService {

  private final MemberDAO memberDao = new MemberDAO();

  @Override
  public ValidationDTO idCheck(IdCheckDTO idCheckDTO) {
    String id = idCheckDTO.getMemberId();
    if (id == null || id.isEmpty()) {
      return new ValidationDTO(BLANK);
    }
    Integer result = memberDao.idCheck(id);
    Word keyWord = duplicationCheckResult(result);

    return switch (keyWord) {
      case EXIST -> new ValidationDTO(UNAVAILABLE);
      case NONE -> new ValidationDTO(AVAILABLE);
      default -> null;
    };
  }

  private Word duplicationCheckResult(Integer result) {
    return result != null && result < 1 ? NONE : EXIST;
  }
}
