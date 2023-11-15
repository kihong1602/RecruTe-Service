package com.juju.service;

import java.util.List;
import com.juju.dto.ExamDto;

public interface ExamService {
  List<ExamDto> selectProblems(String aptId);
}
