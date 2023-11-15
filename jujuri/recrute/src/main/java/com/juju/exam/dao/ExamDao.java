package com.juju.exam.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.juju.common.mybatis.MybatisConnectionFactory;
import com.juju.exam.dto.ExamDto;
import com.juju.exam.service.ExamService;

public class ExamDao implements ExamService {

  @Override
  public List<ExamDto> selectProblems(String aptId) {
    List<ExamDto> examDto = new ArrayList<>();
    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    examDto = sqlSession.selectList("selectProblems", aptId);
    return examDto;
  }

}
