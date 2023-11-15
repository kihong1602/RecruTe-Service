package com.juju.member.dto;

import java.time.LocalDate;

public class MemberDto {
  /*
   * id int primary key auto_increment, member_id varchar(30) not null, password varchar(50) not
   * null, name varchar(30) not null, birth date not null, gender tinyint not null, phone_number
   * varchar(20) not null, email varchar(50) not null, created_date datetime not null, modified_date
   * datetime not null
   */

  private int id;
  private String member_id;
  private String password;
  private String name;
  private LocalDate birth;
  private int gender;
  private String phone_number;
  private String email;
  private String created_date;
  private String modified_date;



  @Override
  public String toString() {
    return "MemberDto [id=" + id + ", member_id=" + member_id + ", password=" + password + ", name="
        + name + ", birth=" + birth + ", gender=" + gender + ", phone_number=" + phone_number
        + ", email=" + email + ", created_date=" + created_date + ", modified_date=" + modified_date
        + "]";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getCreated_date() {
    return created_date;
  }

  public void setCreated_date(String created_date) {
    this.created_date = created_date;
  }

  public String getModified_date() {
    return modified_date;
  }

  public void setModified_date(String modified_date) {
    this.modified_date = modified_date;
  }

  public MemberDto(int id, String member_id, String password, String name, LocalDate birth,
      int gender, String phone_number, String email, String created_date, String modified_date) {
    super();
    this.id = id;
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



}
