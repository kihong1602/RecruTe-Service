package com.blanc.recrute.member.service;

import com.blanc.recrute.common.Count;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dao.MemberDAO;
import com.blanc.recrute.member.dao.MemberDAOImpl;
import com.blanc.recrute.member.dto.LoginDTO;
import com.blanc.recrute.member.dto.MemberDTO;
import com.blanc.recrute.member.dto.MemberInfoDTO;

public class MemberServiceImpl implements MemberService {

  private final MemberDAO MEMBER_DAO = new MemberDAOImpl();

  @Override
  public Integer insertMember(MemberInfoDTO memberDTO) {

    return memberDTO != null ? MEMBER_DAO.insertMember(memberDTO) : 0;

  }

  @Override
  public Word idCheck(String id) {

    if (id == null || id.isEmpty()) {
      return Word.BLANK;
    }

    return MEMBER_DAO.idCheck(id) <= Count.ZERO.getNumber() ? Word.NONE : Word.EXIST;
  }

  @Override
  public boolean loginCheck(LoginDTO loginDTO) {

    MemberDTO memberDTO = new MemberDTO.Builder().memberId(loginDTO.getMemberId())
                                                 .password(loginDTO.getPassword()).build();
    String memberId = MEMBER_DAO.loginCheck(memberDTO);
    //여기서 LoginDTO로 입력

    return memberId != null;

  }

  @Override
  public MemberDTO findEmail(String memberId) {

    String findEmail = MEMBER_DAO.findEmail(new MemberDTO.Builder().memberId(memberId).build());

    return new MemberDTO.Builder().email(findEmail).build();
  }

  @Override
  public Word authGrantMember(String email) {

    int result = MEMBER_DAO.authGrantMember(new MemberDTO.Builder().email(email).build());

    return result > Count.ZERO.getNumber() ? Word.SUCCESS : Word.FAIL;
  }
}
