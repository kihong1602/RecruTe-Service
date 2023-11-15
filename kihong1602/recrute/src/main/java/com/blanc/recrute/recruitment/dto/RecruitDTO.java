package com.blanc.recrute.recruitment.dto;

import java.time.LocalDate;

public class RecruitDTO {

    private final Integer id;
    private final String title;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Integer salary;
    private final String location;
    private final int workForm;
    private final String job;
    private final String skills;
    private final int career;
    private final Integer companyId;

    public RecruitDTO(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.salary = builder.salary;
        this.location = builder.location;
        this.workForm = builder.workForm;
        this.job = builder.job;
        this.skills = builder.skills;
        this.career = builder.career;
        this.companyId = builder.companyId;
    }

    public RecruitDTO(Integer id, String title, LocalDate startDate, LocalDate endDate, Integer salary, String location, int workForm, String job, String skills, int career, Integer companyId) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.location = location;
        this.workForm = workForm;
        this.job = job;
        this.skills = skills;
        this.career = career;
        this.companyId = companyId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    public int getWorkForm() {
        return workForm;
    }

    public String getJob() {
        return job;
    }

    public String getSkills() {
        return skills;
    }

    public int getCareer() {
        return career;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public static class Builder {
        private Integer id;
        private String title;
        private LocalDate startDate;
        private LocalDate endDate;
        private Integer salary;
        private String location;
        private int workForm;
        private String job;
        private String skills;
        private int career;
        private Integer companyId;

        public Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder salary(Integer salary) {
            this.salary = salary;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder workForm(int workForm) {
            this.workForm = workForm;
            return this;
        }

        public Builder job(String job) {
            this.job = job;
            return this;
        }

        public Builder skills(String skills) {
            this.skills = skills;
            return this;
        }

        public Builder career(int career) {
            this.career = career;
            return this;
        }

        public RecruitDTO build() {
            return new RecruitDTO(this);
        }
    }
}
