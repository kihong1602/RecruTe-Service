package com.jisun.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

public class MemberDto {
	
	private int membertbl_id; //auto
	private String member_id;
	private String password;
	private String name;
	private LocalDate birth;
	private int gender;
	private String phone_number;
	private String email;
	private LocalDate created_date; 
	private LocalDate modified_date;
	
	
	
	@Override
	public String toString() {
		return "MemberDto [membertbl_id=" + membertbl_id + ", member_id=" + member_id + ", password=" + password
				+ ", name=" + name + ", birth=" + birth + ", gender=" + gender + ", phone_number=" + phone_number
				+ ", email=" + email + ", created_date=" + created_date + ", modified_date=" + modified_date + "]";
	}
	
	
	public MemberDto(int membertbl_id, String member_id, String password, String name, LocalDate birth, int gender,
			String phone_number, String email, LocalDate created_date, LocalDate modified_date) {
		super();
		this.membertbl_id = membertbl_id;
		this.member_id = member_id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone_number = phone_number;
		this.email = email;
		this.created_date = created_date;
		this.modified_date = modified_date;
	}
	
	
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getMembertbl_id() {
		return membertbl_id;
	}
	public void setMembertbl_id(int membertbl_id) {
		this.membertbl_id = membertbl_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	 

	
}
