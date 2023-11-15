package com.juju.dto;

import java.time.LocalDate;

public class ApplicantDto {
  @Override
  public String toString() {
    return "ApplicantDto [id=" + id + ", apt_id=" + apt_id + ", member_id=" + member_id
        + ", recruitment_id=" + recruitment_id + ", created_date=" + created_date
        + ", modified_date=" + modified_date + "]";
  }

  public ApplicantDto() {
    super();
    // TODO Auto-generated constructor stub
  }

  public ApplicantDto(int id, String apt_id, int member_id, int recruitment_id,
      LocalDate created_date, LocalDate modified_date) {
    super();
    this.id = id;
    this.apt_id = apt_id;
    this.member_id = member_id;
    this.recruitment_id = recruitment_id;
    this.created_date = created_date;
    this.modified_date = modified_date;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getApt_id() {
    return apt_id;
  }

  public void setApt_id(String apt_id) {
    this.apt_id = apt_id;
  }

  public int getMember_id() {
    return member_id;
  }

  public void setMember_id(int member_id) {
    this.member_id = member_id;
  }

  public int getRecruitment_id() {
    return recruitment_id;
  }

  public void setRecruitment_id(int recruitment_id) {
    this.recruitment_id = recruitment_id;
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

  private int id;
  private String apt_id;
  private int member_id;
  private int recruitment_id;
  private LocalDate created_date;
  private LocalDate modified_date;
}
