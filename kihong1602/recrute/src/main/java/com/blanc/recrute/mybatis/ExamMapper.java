package com.blanc.recrute.mybatis;

import com.blanc.recrute.exam.dto.ExaminationDTO;
import com.blanc.recrute.exam.dto.RecruitIdDTO;
import com.blanc.recrute.exam.dto.RecruitInfoDTO;
import java.util.List;

public interface ExamMapper {

  RecruitInfoDTO getRecruitTitleByAptId(String aptId);

  Integer findRecruitIdByExamId(Integer examId);

  List<ExaminationDTO> getExaminationById(Integer recruitId);

  List<String> getApplicantEmail(RecruitIdDTO recruitIdDTO);
}
