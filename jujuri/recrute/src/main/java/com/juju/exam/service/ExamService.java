package com.juju.exam.service;

import java.util.List;
import com.juju.exam.dto.ExamDto;

public interface ExamService {
  List<ExamDto> selectProblems(String aptId);
}
