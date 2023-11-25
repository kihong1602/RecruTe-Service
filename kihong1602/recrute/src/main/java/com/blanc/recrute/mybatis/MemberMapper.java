package com.blanc.recrute.mybatis;

import com.blanc.recrute.member.dto.LoginDTO;
import com.blanc.recrute.member.dto.MemberDTO;
import com.blanc.recrute.member.dto.MemberInfoDTO;


public interface MemberMapper {

  Integer saveMember(MemberInfoDTO memberInfoDTO);

  Integer duplicateId(MemberDTO memberDTO);

  String findEmailById(MemberDTO memberDTO);

  LoginDTO findPasswordByMemberId(LoginDTO loginDTO);

  Integer updateMemberAuthentication(MemberDTO memberDTO);
}
