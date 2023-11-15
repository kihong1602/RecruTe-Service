package com.juju.hire.dao;

import org.apache.ibatis.session.SqlSession;
import com.juju.common.mybatis.MybatisConnectionFactory;
import com.juju.hire.dto.ApplicantDto;
import com.juju.hire.service.ApplicantService;

public class ApplicantDao implements ApplicantService {

  @Override
  public int insertApplicant(ApplicantDto applicantDto) {
    int result = 0;
    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    result = sqlSession.insert("insertApplicant", applicantDto);
    return result;
  }

  public int countApplicant(String recruitmentId) {
    int result = 0;
    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    result = sqlSession.selectOne("countApplicant", recruitmentId);
    return result;
  }

  @Override
  public int checkApplicant(String userId) {
    int count = 0;
    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    count = sqlSession.selectOne("checkApplicant", userId);
    return count;
  }

}
