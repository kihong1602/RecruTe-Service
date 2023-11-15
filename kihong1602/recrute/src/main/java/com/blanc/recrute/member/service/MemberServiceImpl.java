package com.blanc.recrute.member.service;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dao.MemberDAO;
import com.blanc.recrute.member.dao.MemberDAOImpl;
import com.blanc.recrute.member.dto.LoginDTO;
import com.blanc.recrute.member.dto.MemberDTO;
import com.blanc.recrute.member.dto.MemberInfoDTO;

public class MemberServiceImpl implements MemberService {

  private final MemberDAO MEMBER_DAO = new MemberDAOImpl();
  private final int NONE = 0;

  @Override
  public int insertMember(MemberInfoDTO memberDTO) {
    int result = 0;
    if (memberDTO != null) {
      result = MEMBER_DAO.insertMember(memberDTO);
    }

    return result;
  }

  @Override
  public String idCheck(String id) {

    if (id == null || id.isEmpty()) {
      return Word.BLANK;
    }

    return MEMBER_DAO.idCheck(id) <= 0 ? Word.NONE : Word.EXIST;
  }

  @Override
  public boolean loginCheck(LoginDTO loginDTO) {

    MemberDTO memberDTO = new MemberDTO.Builder().memberId(loginDTO.getMemberId())
                                                 .password(loginDTO.getPassword()).build();
    String memberId = MEMBER_DAO.loginCheck(memberDTO);

    return memberId != null;

  }

  @Override
  public MemberDTO findEmail(String memberId) {

    String findEmail = MEMBER_DAO.findEmail(new MemberDTO.Builder().memberId(memberId).build());

    return new MemberDTO.Builder().email(findEmail).build();
  }

  @Override
  public String authGrantMember(String email) {

    int result = MEMBER_DAO.authGrantMember(new MemberDTO.Builder().email(email).build());

    return result > NONE ? Word.SUCCESS : Word.FAIL;
  }
}
