package com.blanc.recrute.member.dao;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dto.LoginDTO;
import com.blanc.recrute.member.dto.MemberDTO;
import com.blanc.recrute.member.dto.MemberInfoDTO;
import com.blanc.recrute.mybatis.MemberMapper;
import com.blanc.recrute.mybatis.MybatisConnectionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;

public class MenberDao {

  private final Logger LOGGER = Logger.getLogger(MenberDao.class.getName());


  public Integer idCheck(String id) {
    MemberDTO memberDTO = new MemberDTO.Builder().memberId(id).build();
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
      return memberMapper.duplicateId(memberDTO);
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      return null;
    }
  }


  public Integer saveMember(MemberInfoDTO memberDTO) {
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
      Integer result = memberMapper.saveMember(memberDTO);
      sqlSession.commit();
      return result;
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      return null;
    }
  }


  public LoginDTO loginRequest(LoginDTO loginDTO) {
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
      return memberMapper.findPasswordByMemberId(loginDTO);
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      return null;
    }
  }


  public String findEmail(MemberDTO memberDTO) {
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
      return memberMapper.findEmailById(memberDTO);
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      return null;
    }
  }


  public Integer memberAuthentication(MemberDTO memberDTO) {
    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
      Integer result = memberMapper.updateMemberAuthentication(memberDTO);
      sqlSession.commit();
      return result;
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      return null;
    }
  }

}
