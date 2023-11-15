package com.jisun.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jisun.dto.CompRecruitDto;
import com.jisun.mybatis.MybatisConnectionFactory;

public class CompRecruitDao {
	
	/*
	 * 채용공고List
	 * 모든 채용공고 목록을 보여주는 메서드
	 * 多rows -> 1row를 List에 저장
	 * */
	public List<CompRecruitDto> selectCompRecruitList(){
		List<CompRecruitDto> resultList = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		resultList = sqlSession.selectList("selectCompRecruitList");
		sqlSession.close();
		return resultList;

	}
	
	/*
	 * 채용공고View
	 * 선택된 채용공고를 보여주는 메서드
	 * 1row -> 1컬럼을 Dto에 저장
	 * */
	public CompRecruitDto selectCompRecruitView (int recruitmenttbl_id) {
		CompRecruitDto resultDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		resultDto = sqlSession.selectOne("selectCompRecruitView", recruitmenttbl_id);
		sqlSession.close();
		return resultDto;
	}
	
	
	/*
	 * 채용공고title
	 * 
	 * 
	 * */
	
	public String selectCompRecruitTitle (int loggedId) {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		String title = null;
		title = sqlSession.selectOne("selectCompRecruitTitle", loggedId);
		sqlSession.close();
		return title;
	}
}
