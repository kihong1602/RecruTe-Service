package com.jisun.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

public class ApplicantDto {
	/*applicant*/
	public int applicanttbl_id; //auto
	private int apt_id; //수험번호
	private LocalDate created_date;  
	private LocalDate modified_date; 
	private int membertbl_id; //외래키
	private int recruitmenttbl_id; //외래키
	
	
	@Override
	public String toString() {
		return "ApplicantDto [applicanttbl_id=" + applicanttbl_id + ", apt_id=" + apt_id + ", created_date="
				+ created_date + ", modified_date=" + modified_date + ", membertbl_id=" + membertbl_id
				+ ", recruitmenttbl_id=" + recruitmenttbl_id + "]";
	}
	
	
	public ApplicantDto(int applicanttbl_id, int apt_id, LocalDate created_date, LocalDate modified_date,
			int membertbl_id, int recruitmenttbl_id) {
		super();
		this.applicanttbl_id = applicanttbl_id;
		this.apt_id = apt_id;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.membertbl_id = membertbl_id;
		this.recruitmenttbl_id = recruitmenttbl_id;
	}
	
	
	public ApplicantDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getApplicanttbl_id() {
		return applicanttbl_id;
	}
	public void setApplicanttbl_id(int applicanttbl_id) {
		this.applicanttbl_id = applicanttbl_id;
	}
	public int getApt_id() {
		return apt_id;
	}
	public void setApt_id(int apt_id) {
		this.apt_id = apt_id;
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
	public int getMembertbl_id() {
		return membertbl_id;
	}
	public void setMembertbl_id(int membertbl_id) {
		this.membertbl_id = membertbl_id;
	}
	public int getRecruitmenttbl_id() {
		return recruitmenttbl_id;
	}
	public void setRecruitmenttbl_id(int recruitmenttbl_id) {
		this.recruitmenttbl_id = recruitmenttbl_id;
	}
	
	

}
