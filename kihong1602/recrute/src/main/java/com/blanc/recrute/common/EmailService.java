package com.blanc.recrute.common;

import static com.blanc.recrute.common.Word.ERROR;

import com.blanc.recrute.exam.dto.RecruitIdDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class EmailService {

  private final EmailSender emailSender = new EmailSender(Host.GOOGLE);
  private final Logger logger = Logger.getLogger(EmailService.class.getName());

  public void SendMemberAuthEmail(String receiveEmail, String authKey) {
    final String TITLE = "RecruTe 회원가입 인증메일입니다.";
    final String HEADER = "<h1>[이메일 인증]</h1>";
    final String CONTENT_1 = "<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>";
    final String EMAIL_AUTH_URL = "<a href='http://localhost:8080/email?email=";
    final String PARAM = "&authKey=";
    final String CONTENT_2 = "' target='_blank'>이메일 인증 확인</a>";

    String content = HEADER + CONTENT_1 + EMAIL_AUTH_URL + receiveEmail + PARAM + authKey + CONTENT_2;

    CompletableFuture<Void> emailFuture =
        CompletableFuture.runAsync(() -> emailSender.mailSend(receiveEmail, TITLE, content));

    try {
      emailFuture.get();
    } catch (InterruptedException | ExecutionException e) {
      logger.log(Level.SEVERE, ERROR.value(), e);
    }
  }

  public String SendExamAuthEmail(List<String> emailList, RecruitIdDTO recruitIdDTO) {
    final String TITLE = "RecruTe 시험응시 인증메일입니다.";
    final String HEADER = "<h1>[이메일 인증]</h1>";
    final String CONTENT_1 = "<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>";
    final String EMAIL_AUTH_URL = "<a href='http://localhost:8080/exam/auth?email=";
    final String CONTENT_2 = "' target='_blank'>이메일 인증 확인</a>";
    final String PARAM = "&recruitId=";

    ExecutorService customExecutor = Executors.newFixedThreadPool(80);
    long startTime = System.currentTimeMillis();
    List<CompletableFuture<String>> futures = new ArrayList<>();
    emailList.forEach(email -> {
      CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
        String content = HEADER + CONTENT_1 + EMAIL_AUTH_URL + email + PARAM + recruitIdDTO.getRecruitId() + CONTENT_2;

        Word result = emailSender.mailSend(email, TITLE, content);
        return result == Word.SUCCESS ? null : email;

      }, customExecutor);
      futures.add(future);
    });
    customExecutor.shutdown();

    List<String> failedEmails = futures.stream()
                                       .map(CompletableFuture::join)
                                       .filter(Objects::nonNull)
                                       .collect(Collectors.toList());
    long endTime = System.currentTimeMillis();
    long duration = endTime - startTime;
    logger.info("Duration: " + duration + "ms");
    return failedEmails.isEmpty() ? Word.SUCCESS.value() : String.join(", ", failedEmails);
  }

}
