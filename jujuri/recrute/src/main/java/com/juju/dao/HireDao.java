package com.juju.dao;

import org.apache.ibatis.session.SqlSession;
import com.juju.dto.HireDto;
import com.juju.mybatis.MybatisConnectionFactory;
import com.juju.service.HireService;

public class HireDao implements HireService {

  @Override
  public HireDto getJobPosting(int id) {
    HireDto hireDto = null;
    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    System.out.println("id===" + id);
    hireDto = sqlSession.selectOne("getJobPosting", id);
    System.out.println("hireDto==" + hireDto);
    sqlSession.close();
    return hireDto;
  }

}
