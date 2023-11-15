package com.blanc.recrute.recruitment.dto;

import java.time.LocalDate;

public class DetailDTO {
    private final Integer recruitId;
    private final String title;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Integer salary;
    private final String location;
    private final String job;
    private final int workForm;
    private final String skills;
    private final int career;
    private final Integer companyId;
    private final String companyName;
    private final String content;

    public DetailDTO(Builder builder) {
        this.recruitId = builder.recruitId;
        this.title = builder.title;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.salary = builder.salary;
        this.location = builder.location;
        this.job = builder.job;
        this.workForm = builder.workForm;
        this.skills = builder.skills;
        this.career = builder.career;
        this.companyId = builder.companyId;
        this.companyName = builder.companyName;
        this.content = builder.content;
    }

    public DetailDTO(Integer recruitId, String title, LocalDate startDate, LocalDate endDate, Integer salary, String location, String job, int workForm, String skills, int career, Integer companyId, String companyName, String content) {
        this.recruitId = recruitId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.location = location;
        this.job = job;
        this.workForm = workForm;
        this.skills = skills;
        this.career = career;
        this.companyId = companyId;
        this.companyName = companyName;
        this.content = content;
    }

    public Integer getRecruitId() {
        return recruitId;
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

    public Integer getSalary() {
        return salary;
    }

    public String getLocation() {
        return location;
    }

    public String getJob() {
        return job;
    }

    public int getWorkForm() {
        return workForm;
    }

    public String getSkills() {
        return skills;
    }

    public int getCareer() {
        return career;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getContent() {
        return content;
    }

    public static class Builder {
        private Integer recruitId;
        private String title;
        private LocalDate startDate;
        private LocalDate endDate;
        private Integer salary;
        private String location;
        private String job;
        private int workForm;
        private String skills;
        private int career;
        private Integer companyId;
        private String companyName;
        private String content;

        public Builder() {
        }

        public Builder recruitId(Integer recruitId) {
            this.recruitId = recruitId;
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

        public Builder job(String job) {
            this.job = job;
            return this;
        }

        public Builder workForm(int workForm) {
            this.workForm = workForm;
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

        public Builder companyId(Integer companyId) {
            this.companyId = companyId;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public DetailDTO build() {
            return new DetailDTO(this);
        }
    }
}
