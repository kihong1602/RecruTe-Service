package com.blanc.recrute.member.dao;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dto.MemberDTO;
import com.blanc.recrute.member.dto.MemberInfoDTO;
import com.blanc.recrute.mybatis.MemberMapper;
import com.blanc.recrute.mybatis.MybatisConnectionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;

public class MemberDAOImpl implements MemberDAO {

  private final Logger LOGGER = Logger.getLogger(MemberDAOImpl.class.getName());

  @Override
  public int idCheck(String id) {

    MemberDTO memberDTO = new MemberDTO.Builder().memberId(id).build();
    Integer result = 0;

    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

      result = memberMapper.duplicateId(memberDTO);

      sqlSession.commit();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR, e);
    }

    return result;
  }

  @Override
  public int insertMember(MemberInfoDTO memberDTO) {
    int result = 0;

    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

//      memberMapper = sqlSession.getMapper(MemberMapper.class);
      result = memberMapper.saveMember(memberDTO);
//      result = sqlSession.insert("saveMember", memberDTO);

      sqlSession.commit();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR, e);

    }

    return result;
  }

  @Override
  public String loginCheck(MemberDTO memberDTO) {
    String memberId = null;

    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

      memberId = memberMapper.loginCheck(memberDTO);

      sqlSession.commit();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR, e);
    }
    return memberId;
  }


  @Override
  public String findEmail(MemberDTO memberDTO) {
    String findEmail = null;

    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

      findEmail = memberMapper.findEmailById(memberDTO);

      sqlSession.commit();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR, e);
    }

    return findEmail;
  }

  @Override
  public int authGrantMember(MemberDTO memberDTO) {
    int result = 0;

    try (SqlSession sqlSession = MybatisConnectionFactory.getSqlSession()) {
      MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

      result = memberMapper.emailAuth(memberDTO);

      sqlSession.commit();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR, e);
    }

    return result;
  }

}
