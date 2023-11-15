package com.jisun.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jisun.dto.ApplicantDto;
import com.jisun.dto.ExamDto;
import com.jisun.mybatis.MybatisConnectionFactory;

public class ExamDao {
	/*
	 * 수험번호 일치
	 * 회원아이디와 수험번호가 일치하는지 확인하는 메서드 
	 * 1row -> 1컬럼 -> 1컬럼을 int에 저장
	 * */
	public int selectAptIdCheck (ExamDto ExamDto) {
		int resultInt = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		resultInt = sqlSession.selectOne("selectAptIdcheck",ExamDto); //exam테이블의 1row의 exam_id이 있으면1 없으면0
		sqlSession.close();
		return resultInt;
		
	}
	
	
	/*
	 * 시험문제 가져오기 
	 * 회원아이디와 수험번호가 일치하면 시험문제를 제공
	 * 多rows --> 多컬럼 -> List로 치환하면 좋겠지만,, 우선 데이터만 보여주면 되므로 .,
	 * */
	public ExamDto selectExamQuestion (ExamDto ExamDto) {
		ExamDto resultDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		resultDto = sqlSession.selectOne("selectExamQuestion", ExamDto);
		sqlSession.close();
		return resultDto;
	}
	
	
	
	
	
	/*
	 * [select] examAuth의 view page list
	 * 			exam테이블의 id를 링크에 삽입
	 * 
	 * */
	public List<Integer> selectExamIdList () {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		List<Integer> resultList = new ArrayList<>(); 
				  	  resultList = sqlSession.selectList("selectExamIdList"); //exam테이블의 多rows의 
		sqlSession.close();
		return resultList;
	}
	
	
	
	
	/*
	 * [select] 시험권한 인증 시 필요한 데이터
	 * 
	 * */
	
	public ExamDto selectExamAuth (int member_id) {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		ExamDto resultDto = null;
				resultDto = sqlSession.selectOne("selectExamAuth",member_id); //1 row
		sqlSession.close();
		return resultDto;
		
	}
	

	
	
	


}
