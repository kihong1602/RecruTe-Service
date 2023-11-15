package com.blanc.recrute.exam.dto;

public class ExaminationDTO {

  private String question;
  private Integer answer;

  public ExaminationDTO(String question, Integer answer) {
    this.question = question;
    this.answer = answer;
  }

  public String getQuestion() {
    return question;
  }

  public Integer getAnswer() {
    return answer;
  }
}
