package com.blanc.recrute.member.service;

import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.member.dao.MemberDAO;
import com.blanc.recrute.member.dto.LoginDTO;
import com.blanc.recrute.member.dto.ValidationDTO;
import org.mindrot.jbcrypt.BCrypt;

public class MemberLoginService implements MemberService {

  private final MemberDAO memberDao = new MemberDAO();

  @Override
  public ValidationDTO loginCheck(LoginDTO loginDTO) {
    LoginDTO savedLoginDto = memberDao.loginCheck(loginDTO);
    boolean invalidResult =
        savedLoginDto != null && passwordInvalid(loginDTO.getPassword(), savedLoginDto.getPassword());

    return invalidResult ? new ValidationDTO(AVAILABLE) : new ValidationDTO(UNAVAILABLE);
  }

  private boolean passwordInvalid(String inputPassword, String savedPassword) {
    return BCrypt.checkpw(inputPassword, savedPassword);
  }
}
