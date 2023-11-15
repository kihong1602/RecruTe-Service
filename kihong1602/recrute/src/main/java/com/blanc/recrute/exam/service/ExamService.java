package com.blanc.recrute.exam.service;

import com.blanc.recrute.common.Word;
import com.blanc.recrute.exam.dao.ExamDAO;
import com.blanc.recrute.exam.dto.ExaminationDTO;
import com.blanc.recrute.exam.dto.RecruitIdDTO;
import com.blanc.recrute.exam.dto.RecruitInfoDTO;
import com.blanc.recrute.exam.dto.answer.AnswerData;
import com.blanc.recrute.member.service.SendEmailService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class ExamService {

  private final ExamDAO EXAM_DAO = new ExamDAO();


  public RecruitInfoDTO getRecruitContent(String aptId) {

    return aptId != null ? EXAM_DAO.getRecruitContent(aptId) : null;

  }

  public List<ExaminationDTO> getExamination(Integer examId) {
    Integer recruitId = EXAM_DAO.getRecruitId(examId);

    return EXAM_DAO.getExamination(recruitId);
  }

  public String saveExamination(AnswerData answerData) {

    return EXAM_DAO.saveExamination(answerData) != null ? Word.SUCCESS : Word.FAIL;
  }

  public void sendEmailToApplicant(RecruitIdDTO recruitIdDTO) {
//    ExecutorService executorService = Executors.newFixedThreadPool(50);
    List<String> emailList = EXAM_DAO.getEmailList(recruitIdDTO);
    long startTime = System.currentTimeMillis();
    //동기
 /*   emailList.forEach(email -> {
      SendEmailService.mailSend(email, String.valueOf(UUID.randomUUID()));
    });*/

    //비동기
    List<CompletableFuture<Void>> futures = new ArrayList<>();
    emailList.forEach(email -> {
      CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
        SendEmailService.mailSend(email, String.valueOf(UUID.randomUUID()));
      });
      futures.add(future);
    });

    CompletableFuture<Void> allOf = CompletableFuture.allOf(
        futures.toArray(new CompletableFuture[0]));
    allOf.join();

    long endTime = System.currentTimeMillis();
    long workTime = endTime - startTime;
    System.out.println("작업시간: " + workTime + "ms");
  }


}
