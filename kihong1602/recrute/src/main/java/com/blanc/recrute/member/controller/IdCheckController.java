package com.blanc.recrute.member.controller;

import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dto.IdCheckDTO;
import com.blanc.recrute.member.dto.InvalidDTO;
import com.blanc.recrute.member.service.MemberService;
import com.blanc.recrute.member.service.MemberServiceImpl;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "check-id", value = "/check-id")
public class IdCheckController extends HttpServlet {

  private final MemberService MEMBER_SERVICE = new MemberServiceImpl();
  private final Gson GSON = new Gson();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    String parsingJSON = JsonUtil.jsonParsing(request);

    IdCheckDTO idCheckDTO = GSON.fromJson(parsingJSON, IdCheckDTO.class);
    String memberId = idCheckDTO.getMemberId();

    String check = MEMBER_SERVICE.idCheck(memberId);

    InvalidDTO invalidDTO = switch (check) {
      case Word.EXIST -> new InvalidDTO(Word.UNAVAILABLE);
      case Word.NONE -> new InvalidDTO(Word.AVAILABLE);
      case Word.BLANK -> new InvalidDTO(Word.BLANK);
      default -> null;
    };

    String result = GSON.toJson(invalidDTO);

    JsonUtil.sendJSON(response, result);
  }
}
