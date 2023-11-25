package com.blanc.recrute.member.controller;

import static com.blanc.recrute.common.Count.ZERO;
import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.UserAuthenticator;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.member.dto.InvalidDTO;
import com.blanc.recrute.member.dto.MemberInfoDTO;
import com.blanc.recrute.member.service.MemberService;
import com.blanc.recrute.member.service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signup", value = "/signup")
public class SignUpController extends HttpServlet {

  private final MemberService memberService = new MemberServiceImpl();
  private final UserAuthenticator userAuthenticator = new UserAuthenticator();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    boolean loginInvalid = userAuthenticator.isAuthenticated(request);

    String path = "";
    if (loginInvalid) {
      response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
      response.sendRedirect("/");
      return;
    } else {
      path = "member/register/signup-process";
    }

    ViewResolver.render(path, request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    MemberInfoDTO memberDto = JsonUtil.jsonParser(request, MemberInfoDTO.class);
    Integer result = memberService.insertMember(memberDto);

    InvalidDTO invalidDTO =
        result > ZERO.getNumber() ? new InvalidDTO(AVAILABLE) : new InvalidDTO(UNAVAILABLE);

    JsonUtil.sendJSON(response, invalidDTO);
  }
}
