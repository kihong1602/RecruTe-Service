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

public class MemberDAO {

  private final Logger LOGGER = Logger.getLogger(MemberDAO.class.getName());


  public Integer idCheck(String id) {

    MemberDTO memberDTO = new MemberDTO.Builder().memberId(id)
                                                 .build();
    Integer result;

    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

      result = memberMapper.duplicateId(memberDTO);

    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      result = null;
    }

    return result;
  }


  public Integer saveMember(MemberInfoDTO memberDTO) {
    Integer result;

    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

      result = memberMapper.saveMember(memberDTO);

      sqlSession.commit();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      result = null;
    }

    return result;
  }


  public LoginDTO loginRequest(LoginDTO loginDTO) {
    LoginDTO savedLoginDto;

    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

      savedLoginDto = memberMapper.findPasswordByMemberId(loginDTO);

    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      savedLoginDto = null;
    }
    return savedLoginDto;
  }


  public String findEmail(MemberDTO memberDTO) {
    String findEmail;

    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

      findEmail = memberMapper.findEmailById(memberDTO);

    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      findEmail = null;
    }

    return findEmail;
  }


  public Integer memberAuthentication(MemberDTO memberDTO) {
    Integer result;

    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

      result = memberMapper.updateMemberAuthentication(memberDTO);

      sqlSession.commit();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR.value(), e);
      result = null;
    }

    return result;
  }

}
