package com.juju.hire.service;

import com.juju.hire.dto.ApplicantDto;

public interface ApplicantService {
  int insertApplicant(ApplicantDto applicantDto);

  int countApplicant(String recruitmentId);

  int checkApplicant(String userId);
}
