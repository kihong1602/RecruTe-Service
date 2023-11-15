package com.juju.member.service;

import java.util.List;
import com.juju.member.dto.MemberDto;

public interface MemberService {
  int insertMember(MemberDto memberDto);

  MemberDto loginMember(MemberDto memberDto);

  int IdCheck(String id);

  List<MemberDto> getEmails(String recruitmentId);

  MemberDto findMember(String userId);
}
