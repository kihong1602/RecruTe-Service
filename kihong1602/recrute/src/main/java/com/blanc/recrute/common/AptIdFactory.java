package com.blanc.recrute.common;

import java.util.UUID;

public class AptIdFactory {

  //apt_id 는 companyID+recruitID+응시순서+로그인할때 사용한 계정의 realID
  //aptMap -> 응시순서 저장 -> 서버 재부팅시 초기화됨. -> 응시순서를 aptId 생성에 사용하려면 테이블 생성해야 할듯
  public static String createAptId() {

    return String.valueOf(UUID.randomUUID()).replace("-", "").substring(0, 10);

  }
}
