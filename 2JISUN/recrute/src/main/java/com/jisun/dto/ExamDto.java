package com.jisun.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

public class ExamDto {

	/*exam*/
	public int examtbl_id; //auto 
	public int recruitmenttbl_id; //외래키
	public String question; // 질문
	public int answer; // 정답
	public LocalDate created_date; //default
	public LocalDate modified_date; //default 
	
	/*applicant*/
	public int applicanttbl_id; //auto
	public int membertbl_id; //외래키
	public int apt_id; // 수험번호
	@Override
	public String toString() {
		return "ExamDto [examtbl_id=" + examtbl_id + ", recruitmenttbl_id=" + recruitmenttbl_id + ", question="
				+ question + ", answer=" + answer + ", created_date=" + created_date + ", modified_date="
				+ modified_date + ", applicanttbl_id=" + applicanttbl_id + ", membertbl_id=" + membertbl_id
				+ ", apt_id=" + apt_id + "]";
	}
	public ExamDto(int examtbl_id, int recruitmenttbl_id, String question, int answer, LocalDate created_date,
			LocalDate modified_date, int applicanttbl_id, int membertbl_id, int apt_id) {
		super();
		this.examtbl_id = examtbl_id;
		this.recruitmenttbl_id = recruitmenttbl_id;
		this.question = question;
		this.answer = answer;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.applicanttbl_id = applicanttbl_id;
		this.membertbl_id = membertbl_id;
		this.apt_id = apt_id;
	}
	public ExamDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getExamtbl_id() {
		return examtbl_id;
	}
	public int getRecruitmenttbl_id() {
		return recruitmenttbl_id;
	}
	public String getQuestion() {
		return question;
	}
	public int getAnswer() {
		return answer;
	}
	public LocalDate getCreated_date() {
		return created_date;
	}
	public LocalDate getModified_date() {
		return modified_date;
	}
	public int getApplicanttbl_id() {
		return applicanttbl_id;
	}
	public int getMembertbl_id() {
		return membertbl_id;
	}
	public int getApt_id() {
		return apt_id;
	}
	public void setExamtbl_id(int examtbl_id) {
		this.examtbl_id = examtbl_id;
	}
	public void setRecruitmenttbl_id(int recruitmenttbl_id) {
		this.recruitmenttbl_id = recruitmenttbl_id;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}
	public void setModified_date(LocalDate modified_date) {
		this.modified_date = modified_date;
	}
	public void setApplicanttbl_id(int applicanttbl_id) {
		this.applicanttbl_id = applicanttbl_id;
	}
	public void setMembertbl_id(int membertbl_id) {
		this.membertbl_id = membertbl_id;
	}
	public void setApt_id(int apt_id) {
		this.apt_id = apt_id;
	}
	
	
}
