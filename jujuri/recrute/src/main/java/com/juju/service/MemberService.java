package com.juju.service;

import java.util.List;
import com.juju.dto.MemberDto;

public interface MemberService {
  int insertMember(MemberDto memberDto);

  MemberDto loginMember(MemberDto memberDto);

  int IdCheck(String id);

  MemberDto findMember(String userId);

  List<MemberDto> getEmails(String recruitmentId);

}
