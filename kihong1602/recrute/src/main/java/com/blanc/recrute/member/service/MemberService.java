package com.blanc.recrute.member.service;

import com.blanc.recrute.member.dto.LoginDTO;
import com.blanc.recrute.member.dto.MemberDTO;
import com.blanc.recrute.member.dto.MemberInfoDTO;

public interface MemberService {

  int insertMember(MemberInfoDTO memberDTO);

  String idCheck(String id);

  boolean loginCheck(LoginDTO loginDTO);

  MemberDTO findEmail(String memberId);

  String authGrantMember(String email);
}
