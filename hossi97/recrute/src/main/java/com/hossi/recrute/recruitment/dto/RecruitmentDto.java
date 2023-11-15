package com.hossi.recrute.recruitment.dto;

import java.time.LocalDate;

public class RecruitmentDto {
    private final Integer rctId;
    private final String title;
    private final String content;
    private final String companyName;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Integer salary;
    private final String location;
    private final Integer contractType;
    private final String job;
    private final String skills;
    private final Integer career;

    RecruitmentDto(
        Integer rctId,
        String title,
        String content,
        String companyName,
        LocalDate startDate,
        LocalDate endDate,
        Integer salary,
        String location,
        Integer contractType,
        String job,
        String skills,
        Integer career
    ) {
        this.rctId = rctId;
        this.title = title;
        this.content = content;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.location = location;
        this.contractType = contractType;
        this.job = job;
        this.skills = skills;
        this.career = career;
    }

    public Integer getRctId() {
        return rctId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getLocation() {
        return location;
    }

    public Integer getContractType() {
        return contractType;
    }

    public String getJob() {
        return job;
    }

    public String getSkills() {
        return skills;
    }

    public Integer getCareer() {
        return career;
    }
}
