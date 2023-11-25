package com.blanc.recrute.member.service;

import static com.blanc.recrute.common.Count.ZERO;
import static com.blanc.recrute.common.Word.BLANK;
import static com.blanc.recrute.common.Word.EXIST;
import static com.blanc.recrute.common.Word.FAIL;
import static com.blanc.recrute.common.Word.NONE;
import static com.blanc.recrute.common.Word.SUCCESS;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dao.MemberDAO;
import com.blanc.recrute.member.dao.MemberDAOImpl;
import com.blanc.recrute.member.dto.LoginDTO;
import com.blanc.recrute.member.dto.MemberDTO;
import com.blanc.recrute.member.dto.MemberInfoDTO;
import org.mindrot.jbcrypt.BCrypt;

public class MemberServiceImpl implements MemberService {

  private final MemberDAO MEMBER_DAO = new MemberDAOImpl();

  @Override
  public Integer insertMember(MemberInfoDTO memberDTO) {
    memberDTO.passwordEncoding();
    return memberDTO != null ? MEMBER_DAO.insertMember(memberDTO) : 0;

  }

  @Override
  public Word idCheck(String id) {

    if (id == null || id.isEmpty()) {
      return BLANK;
    }

    return MEMBER_DAO.idCheck(id) <= ZERO.getNumber() ? NONE : EXIST;
  }

  @Override
  public boolean loginCheck(LoginDTO loginDTO) {

    LoginDTO savedLoginDto = MEMBER_DAO.loginCheck(loginDTO);

    return passwordInvalid(loginDTO.getPassword(), savedLoginDto.getPassword());
  }

  @Override
  public String findEmail(String memberId) {

    String findEmail = MEMBER_DAO.findEmail(new MemberDTO.Builder().memberId(memberId)
                                                                   .build());

    return findEmail != null ? findEmail : "";
  }

  @Override
  public Word authGrantMember(String email) {

    int result = MEMBER_DAO.authGrantMember(new MemberDTO.Builder().email(email)
                                                                   .build());

    return result > ZERO.getNumber() ? SUCCESS : FAIL;
  }

  public boolean passwordInvalid(String inputPassword, String savedPassword) {
    return BCrypt.checkpw(inputPassword, savedPassword);
  }
}
