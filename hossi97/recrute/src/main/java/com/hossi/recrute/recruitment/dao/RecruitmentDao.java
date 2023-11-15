package com.hossi.recrute.recruitment.dao;

import com.hossi.recrute.common.mybatis.MyBatisConnectionManager;
import com.hossi.recrute.common.mybatis.ResultType;
import com.hossi.recrute.recruitment.dto.ApplicantReqDto;
import com.hossi.recrute.recruitment.dto.RecruitmentDto;
import org.apache.ibatis.session.SqlSession;

import static com.hossi.recrute.common.mybatis.ResultType.FAILURE;
import static com.hossi.recrute.common.mybatis.ResultType.SUCCESS;

public class RecruitmentDao {
    public RecruitmentDto findRecruitment(Integer rctId) {
        SqlSession sqlSession = MyBatisConnectionManager.getSqlSession();
        RecruitmentDto recruitmentDto = sqlSession.selectOne("selectRecruitmentByRctId", rctId);
        sqlSession.close();

        return recruitmentDto;
    }

    public ResultType saveRecruitment(ApplicantReqDto applicantDto) {
        SqlSession sqlSession = MyBatisConnectionManager.getSqlSession();
        int result = sqlSession.insert("insertApplicant", applicantDto);
        sqlSession.close();

        return SUCCESS.equals(result) ? SUCCESS : FAILURE;
    }
}
