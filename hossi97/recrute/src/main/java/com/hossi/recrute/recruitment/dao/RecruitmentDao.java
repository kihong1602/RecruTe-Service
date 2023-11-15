package com.hossi.recrute.recruitment.dao;

import com.hossi.recrute.common.MyBatisConnectionFactory;
import com.hossi.recrute.recruitment.dto.ApplicantDto;
import com.hossi.recrute.recruitment.dto.RecruitmentDto;
import org.apache.ibatis.session.SqlSession;

public class RecruitmentDao {
    public RecruitmentDto getRecruitmentByRctId(Integer rctId) {
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        RecruitmentDto recruitmentDto = sqlSession.selectOne("selectRecruitmentByRctId", rctId);
        sqlSession.close();

        return recruitmentDto;
    }

    public void setRecruitment(ApplicantDto applicantDto) {
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        sqlSession.insert("saveApplicant", applicantDto);
        sqlSession.close();
    }
}
