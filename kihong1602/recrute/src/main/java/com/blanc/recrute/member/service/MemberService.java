package com.blanc.recrute.member.service;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dto.LoginDTO;
import com.blanc.recrute.member.dto.MemberDTO;
import com.blanc.recrute.member.dto.MemberInfoDTO;

public interface MemberService {

  Integer insertMember(MemberInfoDTO memberDTO);

  Word idCheck(String id);

  boolean loginCheck(LoginDTO loginDTO);

  MemberDTO findEmail(String memberId);

  Word authGrantMember(String email);
}
