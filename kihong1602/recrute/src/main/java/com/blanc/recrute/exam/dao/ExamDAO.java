package com.blanc.recrute.exam.dao;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.exam.dto.ApplicantUserInfo;
import com.blanc.recrute.exam.dto.ExaminationDTO;
import com.blanc.recrute.exam.dto.RecruitIdDTO;
import com.blanc.recrute.exam.dto.RecruitInfoDTO;
import com.blanc.recrute.exam.dto.answer.AnswerData;
import com.blanc.recrute.mybatis.ExamMapper;
import com.blanc.recrute.mybatis.MybatisConnectionFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;

public class ExamDAO {

  private final Logger LOGGER = Logger.getLogger(ExamDAO.class.getName());

  public RecruitInfoDTO getRecruitContent(String aptId) {

    RecruitInfoDTO recruitInfoDto;
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);
      recruitInfoDto = examMapper.getRecruitTitleByAptId(aptId);
      sqlSession.commit();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      recruitInfoDto = null;
    }
    return recruitInfoDto;
  }

  public Integer getRecruitId(Integer examId) {

    Integer recruitId;
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);

      recruitId = examMapper.findRecruitIdByExamId(examId);

    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      recruitId = null;
    }

    return recruitId;
  }

  public List<ExaminationDTO> getExamination(Integer recruitId) {

    List<ExaminationDTO> examinationDTOList;
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);

      examinationDTOList = examMapper.getExaminationById(recruitId);

    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      examinationDTOList = null;
    }
    return examinationDTOList;
  }


  public List<ApplicantUserInfo> getEmailList(RecruitIdDTO recruitIdDTO) {
    List<ApplicantUserInfo> emailList;
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);

      emailList = examMapper.getApplicantEmail(recruitIdDTO);

    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      emailList = null;
    }
    return emailList;
  }

  public String saveExamination(AnswerData answerData) {
    String receiveTest = answerData.toString();
    LOGGER.info(receiveTest);
    return answerData.toString();
  }

}
