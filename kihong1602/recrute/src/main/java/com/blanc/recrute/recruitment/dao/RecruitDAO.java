package com.blanc.recrute.recruitment.dao;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.mybatis.MybatisConnectionFactory;
import com.blanc.recrute.mybatis.RecruitMapper;
import com.blanc.recrute.recruitment.dto.ApplyDTO;
import com.blanc.recrute.recruitment.dto.DetailDTO;
import com.blanc.recrute.recruitment.dto.RecruitDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;

public class RecruitDAO {

  private final Logger LOGGER = Logger.getLogger(RecruitDAO.class.getName());

  public DetailDTO findRctDetail(RecruitDTO recruitDTO) {
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      RecruitMapper recruitMapper = sqlSession.getMapper(RecruitMapper.class);
      return recruitMapper.findRctDetailById(recruitDTO);
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      return null;
    }
  }

  public Integer apply(ApplyDTO applyDTO) {
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      RecruitMapper recruitMapper = sqlSession.getMapper(RecruitMapper.class);
      Integer result = recruitMapper.saveApply(applyDTO);
      sqlSession.commit();
      return result;
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      return null;
    }
  }

  public Integer findMemberPk(String memberRealId) {
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      RecruitMapper recruitMapper = sqlSession.getMapper(RecruitMapper.class);
      return recruitMapper.findIdByMemberPk(memberRealId);
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      return null;
    }
  }

}
