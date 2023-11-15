package com.juju.member.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.juju.common.mybatis.MybatisConnectionFactory;
import com.juju.member.dto.MemberDto;
import com.juju.member.service.MemberService;

public class MemberDao implements MemberService {

  @Override
  public int insertMember(MemberDto memberDto) {
    int result = 0;
    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    result = sqlSession.insert("insertMember", memberDto);
    return result;
  }

  @Override
  public MemberDto loginMember(MemberDto memberDto) {
    MemberDto loginDto = null;
    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    loginDto = sqlSession.selectOne("loginMember", memberDto);
    sqlSession.close();
    return loginDto;
  }

  @Override
  public int IdCheck(String id) {
    int result = 0;
    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    result = sqlSession.selectOne("idCheck", id);
    sqlSession.close();
    return result;

  }

  @Override
  public MemberDto findMember(String userId) {
    MemberDto findDto = null;
    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    findDto = sqlSession.selectOne("findMember", userId);
    sqlSession.close();
    return findDto;
  }

  @Override
  public List<MemberDto> getEmails(String recruitmentId) {
    List<MemberDto> emailDto = new ArrayList<>();
    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    emailDto = sqlSession.selectList("getEmails", recruitmentId);
    sqlSession.close();
    return emailDto;
  }
}
