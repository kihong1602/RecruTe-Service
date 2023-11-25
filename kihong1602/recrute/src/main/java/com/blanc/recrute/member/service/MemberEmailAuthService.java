package com.blanc.recrute.member.service;

import static com.blanc.recrute.common.Word.AUTH_KEY;
import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.FAIL;
import static com.blanc.recrute.common.Word.SUCCESS;

import com.blanc.recrute.common.CookieManager;
import com.blanc.recrute.common.EmailService;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dao.MemberDAO;
import com.blanc.recrute.member.dto.ConfirmValueDTO;
import com.blanc.recrute.member.dto.MemberDTO;
import com.blanc.recrute.member.dto.ValidationDTO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.UUID;

public class MemberEmailAuthService implements MemberService {

  private final MemberDAO memberDao = new MemberDAO();
  private final EmailService emailService = new EmailService();

  @Override
  public ValidationDTO sendAuthEmail(HttpServletRequest request, ConfirmValueDTO confirmValueDTO) {
    String requestData = confirmValueDTO.getKey();

    HttpSession session = request.getSession(false);
    String memberId = getMemberId(request, requestData, session);

    MemberDTO inputMemberId = new MemberDTO.Builder().memberId(memberId)
                                                     .build();
    String savedEmail = memberDao.findEmail(inputMemberId);

    if (savedEmail != null) {
      String authKey = String.valueOf(UUID.randomUUID());

      emailService.sendMemberAuthEmail(savedEmail, authKey);
      session.setAttribute(AUTH_KEY.value(), authKey);
    } else {
      throw new NullPointerException("이메일이 존재하지않습니다.");
    }

    return new ValidationDTO(AVAILABLE);
  }

  @Override
  public Word authGrantMember(HttpServletRequest request, String email) {
    boolean authKeyValidationResult = validateAuthKey(request);
    if (authKeyValidationResult) {
      Integer result = memberDao.authGrantMember(new MemberDTO.Builder().email(email)
                                                                        .build());
      if (result == null) {
        return FAIL;
      }

    } else {
      return FAIL;
    }

    return SUCCESS;
  }

  private String getMemberId(HttpServletRequest request, String requestData,
      HttpSession session) {
    String memberId;
    if (requestData.equals("sid")) {

      Cookie authCookie = CookieManager.getCookie(request, requestData);

      if (authCookie != null) {
        memberId = (String) session.getAttribute(authCookie.getValue());
      } else {
        throw new IllegalArgumentException("올바르지않은 인증 정보입니다.");
      }

    } else {
      memberId = requestData;
    }
    return memberId;
  }

  private boolean validateAuthKey(HttpServletRequest request) {
    String authKey = request.getParameter(AUTH_KEY.value());
    HttpSession session = request.getSession(false);
    String sessionAuthKey = (String) session.getAttribute(AUTH_KEY.value());
    return authKey.equals(sessionAuthKey);
  }
}
