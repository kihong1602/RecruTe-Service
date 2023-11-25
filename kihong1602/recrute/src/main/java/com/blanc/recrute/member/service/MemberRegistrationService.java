package com.blanc.recrute.member.service;

import static com.blanc.recrute.common.Count.ZERO;
import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.member.dao.MemberDAO;
import com.blanc.recrute.member.dto.MemberInfoDTO;
import com.blanc.recrute.member.dto.ValidationDTO;

public class MemberRegistrationService implements MemberService {

  private final MemberDAO memberDao = new MemberDAO();

  @Override
  public ValidationDTO memberRegistration(MemberInfoDTO memberDTO) {

    memberDTO.passwordEncoding();

    Integer result = memberDao.insertMember(memberDTO);

    return result > ZERO.getNumber() ? new ValidationDTO(AVAILABLE) : new ValidationDTO(UNAVAILABLE);
  }

}
