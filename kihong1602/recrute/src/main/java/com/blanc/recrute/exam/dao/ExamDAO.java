package com.blanc.recrute.exam.dao;

import com.blanc.recrute.common.Word;
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

    RecruitInfoDTO examDTO = null;
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);
      examDTO = examMapper.getRecruitTitleByAptId(aptId);
      sqlSession.commit();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR, e);
    }
    return examDTO;
  }

  /*  getExamination()
   * 현재는 question 과 answer 컬럼이 exam 테이블에 종속되어있으므로 examId로 recruitId 를 조회하고
   * recruitId를 통해 값을 불러올 것
   * 리팩토링시 테이블 분리 예정이며 해당시점에는 examId를 통해 question 과 answer 조회예정
   */
  public List<ExaminationDTO> getExamination(Integer recruitId) {

    List<ExaminationDTO> examinationDTOList = null;
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);

      examinationDTOList = examMapper.getExaminationById(recruitId);

      sqlSession.commit();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR, e);
    }
    return examinationDTOList;
  }

  public Integer getRecruitId(Integer examId) {

    Integer recruitId = null;
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);

      recruitId = examMapper.findRecruitIdByExamId(examId);

      sqlSession.commit();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR, e);
    }

    return recruitId;
  }


  public List<String> getEmailList(RecruitIdDTO recruitIdDTO) {
    List<String> emailList = null;
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);

      emailList = examMapper.getApplicantEmail(recruitIdDTO);

      sqlSession.commit();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR, e);
    }
    return emailList;
  }

  public String saveExamination(AnswerData answerData) {
    System.out.println(answerData.toString());
    return answerData.toString();
  }

}
