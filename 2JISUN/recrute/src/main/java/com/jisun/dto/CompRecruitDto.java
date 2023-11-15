package com.jisun.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

public class CompRecruitDto {
	
	
	/*company*/
	//public int companytbl_id; //auto_increment
	public String company_name; //회사명

	/*recruitment*/
	public int recruitmenttbl_id; //auto
	public int companytbl_id; // 외래키
	public String title; 
	public LocalDate start_date; 
	public LocalDate end_date; 
	public int salary; 
	public String location; 
	public int work_form; 
	public String job; 
	public String skills; 
	public String career; 
	private LocalDate created_date; 
	private LocalDate modified_date; 
	
	


	
	
	
	@Override
	public String toString() {
		return "CompRecruitDto [recruitmenttbl_id=" + recruitmenttbl_id + ", title=" + title + ", start_date="
				+ start_date + ", end_date=" + end_date + ", salary=" + salary + ", location=" + location
				+ ", work_form=" + work_form + ", job=" + job + ", skills=" + skills + ", career=" + career
				+ ", created_date=" + created_date + ", modified_date=" + modified_date + ", companytbl_id="
				+ companytbl_id + ", company_name=" + company_name + "]";
	}

	public CompRecruitDto(int recruitmenttbl_id, String title, LocalDate start_date, LocalDate end_date, int salary,
			String location, int work_form, String job, String skills, String career, LocalDate created_date,
			LocalDate modified_date, int companytbl_id, String company_name) {
		super();
		this.recruitmenttbl_id = recruitmenttbl_id;
		this.title = title;
		this.start_date = start_date;
		this.end_date = end_date;
		this.salary = salary;
		this.location = location;
		this.work_form = work_form;
		this.job = job;
		this.skills = skills;
		this.career = career;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.companytbl_id = companytbl_id;
		this.company_name = company_name;
	}

	public CompRecruitDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRecruitmenttbl_id() {
		return recruitmenttbl_id;
	}

	public void setRecruitmenttbl_id(int recruitmenttbl_id) {
		this.recruitmenttbl_id = recruitmenttbl_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getWork_form() {
		return work_form;
	}

	public void setWork_form(int work_form) {
		this.work_form = work_form;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public LocalDate getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}

	public LocalDate getModified_date() {
		return modified_date;
	}

	public void setModified_date(LocalDate modified_date) {
		this.modified_date = modified_date;
	}

	public int getCompanytbl_id() {
		return companytbl_id;
	}

	public void setCompanytbl_id(int companytbl_id) {
		this.companytbl_id = companytbl_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
}
