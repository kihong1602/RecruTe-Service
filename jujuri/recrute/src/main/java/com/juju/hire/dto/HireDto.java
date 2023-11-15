package com.juju.hire.dto;

import java.time.LocalDate;

public class HireDto {
  private int id;
  private String title;
  private String start_date;
  private String end_date;
  private int salary;
  private String location;
  private int work_form;
  private String job;
  private String skills;
  private int career;
  private LocalDate created_date;
  private LocalDate modified_date;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getStart_date() {
    return start_date;
  }

  public HireDto() {
    super();
    // TODO Auto-generated constructor stub
  }

  public HireDto(int id, String title, String start_date, String end_date, int salary,
      String location, int work_form, String job, String skills, int career, LocalDate created_date,
      LocalDate modified_date) {
    super();
    this.id = id;
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
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
  }

  public void setStart_date(String start_date) {
    this.start_date = start_date;
  }

  public String getEnd_date() {
    return end_date;
  }

  public void setEnd_date(String end_date) {
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

  public int getCareer() {
    return career;
  }

  public void setCareer(int career) {
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
}
