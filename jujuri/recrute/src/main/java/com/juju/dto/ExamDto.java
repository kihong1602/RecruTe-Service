package com.juju.dto;

public class ExamDto {
  // question id answer recruitment_id
  private int id;
  private String question;
  private int answer;
  private int recruitmentId;

  public int getId() {
    return id;
  }

  public ExamDto(int id, String question, int answer, int recruitmentId) {
    this.id = id;
    this.question = question;
    this.answer = answer;
    this.recruitmentId = recruitmentId;
  }

  public ExamDto() {}

  @Override
  public String toString() {
    return "ExamDto [id=" + id + ", question=" + question + ", answer=" + answer
        + ", recruitmentId=" + recruitmentId + "]";
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public int getAnswer() {
    return answer;
  }

  public void setAnswer(int answer) {
    this.answer = answer;
  }

  public int getRecruitmentId() {
    return recruitmentId;
  }

  public void setRecruitmentId(int recruitmentId) {
    this.recruitmentId = recruitmentId;
  }
}
