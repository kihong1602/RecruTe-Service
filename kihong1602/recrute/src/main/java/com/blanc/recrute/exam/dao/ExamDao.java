package com.blanc.recrute.exam.dao;

import static com.blanc.recrute.common.Count.ZERO;
import static com.blanc.recrute.common.Word.ERROR;
import static com.blanc.recrute.common.Word.FAIL;
import static com.blanc.recrute.common.Word.SUCCESS;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.exam.dto.ApplicantUserInfo;
import com.blanc.recrute.exam.dto.ExaminationDTO;
import com.blanc.recrute.exam.dto.RecruitIdDTO;
import com.blanc.recrute.exam.dto.RecruitInfoDTO;
import com.blanc.recrute.exam.dto.answer.AnswerData;
import com.blanc.recrute.mybatis.ExamMapper;
import com.blanc.recrute.mybatis.MybatisConnectionFactory;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;

public class ExamDao {

  private final Logger LOGGER = Logger.getLogger(ExamDao.class.getName());

  public RecruitInfoDTO getRecruitContent(String aptId) {

    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);
      return examMapper.getRecruitTitleByAptId(aptId);
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, ERROR.value(), e);
      return null;
    }
  }

  public Integer getRecruitId(Integer examId) {
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);
      return examMapper.findRecruitIdByExamId(examId);
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, ERROR.value(), e);
      return null;
    }
  }

  public List<ExaminationDTO> getExamination(Integer recruitId) {
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);
      return examMapper.getExaminationById(recruitId);
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, ERROR.value(), e);
      return Collections.emptyList();
    }
  }


  public List<ApplicantUserInfo> getEmailList(RecruitIdDTO recruitIdDTO) {
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);
      return examMapper.getApplicantEmail(recruitIdDTO);
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, ERROR.value(), e);
      return Collections.emptyList();
    }
  }

  public Word validationAptId(String aptId) {
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);
      Integer validationResult = examMapper.validationAptId(aptId);
      return validationResult > ZERO.getNumber() ? SUCCESS : FAIL;
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, ERROR.value(), e);
      return FAIL;
    }
  }

  public String saveExamination(AnswerData answerData) {
    String receiveTest = answerData.toString();
    LOGGER.info(receiveTest);
    return answerData.toString();
  }

}
