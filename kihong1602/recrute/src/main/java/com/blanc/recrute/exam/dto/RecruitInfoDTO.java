package com.blanc.recrute.exam.dto;

import java.time.LocalDate;

public class RecruitInfoDTO {

  private String title;
  private LocalDate startDate;
  private LocalDate endDate;

  public RecruitInfoDTO(String title, LocalDate startDate, LocalDate endDate) {
    this.title = title;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public RecruitInfoDTO(Builder builder) {
    this.title = builder.title;
    this.startDate = builder.startDate;
    this.endDate = builder.endDate;
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

  public static class Builder {

    private String title;
    private LocalDate startDate;
    private LocalDate endDate;

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

    public RecruitInfoDTO build() {
      return new RecruitInfoDTO(this);
    }
  }
}
