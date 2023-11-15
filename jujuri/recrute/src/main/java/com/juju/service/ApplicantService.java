package com.juju.service;

import com.juju.dto.ApplicantDto;

public interface ApplicantService {
  int insertApplicant(ApplicantDto applicantDto);

  int countApplicant(String recruitmentId);
}
