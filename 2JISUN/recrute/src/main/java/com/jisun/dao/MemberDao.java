package com.jisun.dao;

import org.apache.ibatis.session.SqlSession;


import com.jisun.dto.MemberDto;
import com.jisun.mybatis.MybatisConnectionFactory;

public class MemberDao {
	
    /*
     * 회원가입
     * 아이디 중복 확인 메서드
     */
	public int selectIdCheck (String member_id) {
		int resultInt = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		resultInt = sqlSession.selectOne("selectIdCheck" , member_id); //0 or 1
		sqlSession.close();
		return resultInt;
	}

	
    /*
     * 회원가입
     * 성공시 회원정보를 db에 삽입 메서드
     */
	public int insertInfoMember(MemberDto memberDto) {
		int resultInt = 0;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
        resultInt = sqlSession.insert("insertInfoMember", memberDto); 
        sqlSession.close();
        return resultInt;
	}

	
    /*
     * 로그인
     * 아이디와 비밀번호가 일치하는지 확인하는 메서드
     */
	public MemberDto selectLoginMember(MemberDto memberDto) {
		MemberDto resultDto = null;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
        resultDto = sqlSession.selectOne("selectLoginMember", memberDto); //selectOne : 결과값이 하나의 row일때
        sqlSession.close();
        return resultDto;
	}

}
