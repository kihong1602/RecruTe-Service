package com.blanc.recrute.common.email;

import static com.blanc.recrute.common.Word.ERROR;
import static com.blanc.recrute.common.Word.SUCCESS;

import com.blanc.recrute.common.Host;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.exam.dto.ApplicantUserInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailService {

  private final EmailSender emailSender = new EmailSender(Host.GOOGLE);
  private final Logger logger = Logger.getLogger(EmailService.class.getName());

  public void sendMemberAuthEmail(String receiveEmail, String authKey) {
    final String TITLE = "RecruTe 회원가입 인증메일입니다.";
    final String HEADER = "<h1>[이메일 인증]</h1>";
    final String CONTENT_1 = "<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>";
    final String EMAIL_AUTH_URL = "<a href='http://localhost:8080/email?email=";
    final String PARAM = "&authKey=";
    final String CONTENT_2 = "' target='_blank'>이메일 인증 확인</a>";

    String content = HEADER + CONTENT_1 + EMAIL_AUTH_URL + receiveEmail + PARAM + authKey + CONTENT_2;
    logger.info(content);

    CompletableFuture<Void> emailFuture =
        CompletableFuture.runAsync(() -> emailSender.mailSend(receiveEmail, TITLE, content));

    try {
      emailFuture.get();
    } catch (InterruptedException | ExecutionException e) {
      logger.log(Level.SEVERE, ERROR.value(), e);
    }
  }

  public String sendExamAuthEmail(List<ApplicantUserInfo> applicantUserInfoList, String recruitId) {
    final String TITLE = "RecruTe 시험응시 인증메일입니다.";
    final String HEADER = "<h1>[이메일 인증]</h1>";
    final String CONTENT_1 = "<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>";
    final String EMAIL_AUTH_URL = "<a href='http://localhost:8080/exam/auth/";
    final String RECRUIT_ID = recruitId;
    final String EMAIL_PARAM = "?email=";
    final String APT_ID_PARAM = "&aptId=";
    final String CONTENT_2 = "' target='_blank'>이메일 인증 확인</a>";

    ExecutorService customExecutor = Executors.newFixedThreadPool(80);
    long startTime = System.currentTimeMillis();
    List<CompletableFuture<String>> futures = new ArrayList<>();
    for (ApplicantUserInfo userInfo : applicantUserInfoList) {
      String email = userInfo.getEmail();
      String aptId = userInfo.getAptId();

      CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
        String content =
            HEADER + CONTENT_1 + EMAIL_AUTH_URL + RECRUIT_ID + EMAIL_PARAM + email + APT_ID_PARAM + aptId + CONTENT_2;
        if (email.equals("kihong@gmail.com")) {
          logger.info(content);
        }
        Word result = emailSender.mailSend(email, TITLE, content);
        return result == SUCCESS ? null : email;

      }, customExecutor);
      futures.add(future);
    }

    customExecutor.shutdown();

    List<String> failedEmails = futures.stream()
                                       .map(CompletableFuture::join)
                                       .filter(Objects::nonNull)
                                       .toList();
    long endTime = System.currentTimeMillis();
    long duration = endTime - startTime;
    String msg = "ASync Duration: " + duration + "ms";
    logger.info(msg);
    return failedEmails.isEmpty() ? SUCCESS.value() : String.join(", ", failedEmails);
  }

}
