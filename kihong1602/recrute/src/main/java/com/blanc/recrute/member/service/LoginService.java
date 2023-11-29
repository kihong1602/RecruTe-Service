package com.blanc.recrute.member.service;

import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.member.dao.MemberDAO;
import com.blanc.recrute.member.dto.LoginDTO;
import com.blanc.recrute.member.dto.ValidationDTO;
import org.mindrot.jbcrypt.BCrypt;

public class LoginService {

  private final MemberDAO memberDao = new MemberDAO();


  public ValidationDTO loginRequest(LoginDTO inputLoginDto) {
    LoginDTO savedLoginDto = memberDao.loginRequest(inputLoginDto);

    if (savedLoginDto == null) {
      throw new NullPointerException("존재하지 않는 아이디입니다.");
    }

    return loginProcess(inputLoginDto, savedLoginDto);
  }

  private ValidationDTO loginProcess(LoginDTO inputLoginDto, LoginDTO savedLoginDto) {
    String inputPw = inputLoginDto.getPassword();
    String savedPw = savedLoginDto.getPassword();

    boolean invalidResult = validationPassword(inputPw, savedPw);

    return invalidResult ? new ValidationDTO(AVAILABLE) : new ValidationDTO(UNAVAILABLE);
  }

  private boolean validationPassword(String inputPassword, String savedPassword) {
    return BCrypt.checkpw(inputPassword, savedPassword);
  }
}
