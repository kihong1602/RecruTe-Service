package com.juju.hire.dao;

import org.apache.ibatis.session.SqlSession;
import com.juju.common.mybatis.MybatisConnectionFactory;
import com.juju.hire.dto.HireDto;
import com.juju.hire.service.HireService;

public class HireDao implements HireService {

  @Override
  public HireDto getJobPosting(int id) {
    HireDto hireDto = null;
    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    hireDto = sqlSession.selectOne("getJobPosting", id);
    sqlSession.close();
    return hireDto;
  }

}
