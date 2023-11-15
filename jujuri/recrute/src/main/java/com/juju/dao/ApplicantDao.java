package com.juju.dao;

import org.apache.ibatis.session.SqlSession;
import com.juju.dto.ApplicantDto;
import com.juju.mybatis.MybatisConnectionFactory;
import com.juju.service.ApplicantService;

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

}
