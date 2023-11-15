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

    DetailDTO detailDTO = null;

    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      RecruitMapper recruitMapper = sqlSession.getMapper(RecruitMapper.class);
      detailDTO = recruitMapper.findRctDetailById(recruitDTO);

      sqlSession.commit();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR, e);
    }

    return detailDTO;
  }

  public int apply(ApplyDTO applyDTO) {

    int result = 0;
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      RecruitMapper recruitMapper = sqlSession.getMapper(RecruitMapper.class);

      result = recruitMapper.saveApply(applyDTO);
      sqlSession.commit();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR, e);
    }

    return result;
  }

  public Integer findMemberId(String memberRealId) {

    Integer id = null;
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      RecruitMapper recruitMapper = sqlSession.getMapper(RecruitMapper.class);

      id = recruitMapper.findIdByMemberId(memberRealId);
      sqlSession.commit();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR, e);
    }

    return id;
  }

}
