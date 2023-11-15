package com.hossi.recrute.recruitment.service;

import com.hossi.recrute.recruitment.dao.RecruitmentDao;
import com.hossi.recrute.recruitment.dto.ApplicantDto;
import com.hossi.recrute.recruitment.dto.RecruitmentDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RecruitmentService {
    private final RecruitmentDao recruitmentDao = new RecruitmentDao();

    public RecruitmentDto getRecruitment(Integer rctId) {
        return recruitmentDao.getRecruitmentByRctId(rctId);
    }

    public void applyRecruitment(Integer id, Integer rctId) {
        String aptId = createAptId(id, rctId);
        ApplicantDto applicantDto = new ApplicantDto.Builder()
            .aptId(aptId)
            .id(id)
            .rctId(rctId)
            .build();
        recruitmentDao.setRecruitment(applicantDto);
    }

    private String createAptId(Integer id, Integer rctId){
        StringBuilder sb = new StringBuilder();

        int num = (id + rctId) % 10000;

        if (num < 100) sb.append("00").append(num);
        else if (num < 1000) sb.append("0").append(num);
        else sb.append(num);

        sb.append(LocalTime.now());

        String comb = sb.toString();
        String[] time = comb.split("[:.]");

        return Arrays.stream(time).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }
}
