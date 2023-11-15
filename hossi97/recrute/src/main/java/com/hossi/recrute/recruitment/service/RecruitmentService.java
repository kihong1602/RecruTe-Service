package com.hossi.recrute.recruitment.service;

import com.hossi.recrute.common.mybatis.ResultType;
import com.hossi.recrute.recruitment.dao.RecruitmentDao;
import com.hossi.recrute.recruitment.dto.ApplicantReqDto;
import com.hossi.recrute.recruitment.dto.RecruitmentDto;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class RecruitmentService {
    private final RecruitmentDao recruitmentDao = new RecruitmentDao();

    public RecruitmentDto getRecruitment(Integer rctId) {
        return recruitmentDao.findRecruitment(rctId);
    }

    public ResultType applyRecruitment(ApplicantReqDto applicantReqDto) {
        createAndSetAptId(applicantReqDto);
        return recruitmentDao.saveRecruitment(applicantReqDto);
    }

    private void createAndSetAptId(ApplicantReqDto applicantReqDto){
        StringBuilder sb = new StringBuilder();
        Integer id = applicantReqDto.getId();
        Integer rctId = applicantReqDto.getRctId();

        int num = (id + rctId) % 10000;

        if (num < 100) sb.append("00").append(num);
        else if (num < 1000) sb.append("0").append(num);
        else sb.append(num);

        sb.append(LocalTime.now());

        String comb = sb.toString();
        String[] time = comb.split("[:.]");

        applicantReqDto.setAptId(Arrays.stream(time)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.joining()));
    }
}
