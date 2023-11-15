package com.blanc.recrute.recruitment.controller;

import com.blanc.recrute.common.CookieManager;
import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.URLParser;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dto.InvalidDTO;
import com.blanc.recrute.recruitment.dto.ApplyInfoDTO;
import com.blanc.recrute.recruitment.dto.DetailDTO;
import com.blanc.recrute.recruitment.service.RecruitService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RecruitController", value = "/recruitments/*")
public class RecruitController extends HttpServlet {


  private final RecruitService RECRUIT_SERVICE = new RecruitService();
  private final Gson GSON = new Gson();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Integer recruitId = URLParser.getLastURI(request);

    DetailDTO detailDTO = RECRUIT_SERVICE.findRctDetail(recruitId);

    if (detailDTO != null) {
      request.setAttribute("detailDTO", detailDTO);
    }

    String path = "recruitment/rct-detail";
    ViewResolver.render(path, request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    //비동기 처리 apt_id 는 회사ID+회사Name+응시순서+@로 입력
    //외래키 삽입을 위해 MemberDTO 사용해야함

    String parsingJSON = JsonUtil.jsonParsing(request);

    ApplyInfoDTO applyInfoDTO = GSON.fromJson(parsingJSON, ApplyInfoDTO.class);

    Cookie AuthCookie = CookieManager.getCookie(request, "sid");

    if (AuthCookie != null) {

      String memberId = (String) request.getSession().getAttribute(AuthCookie.getValue());
      String result = RECRUIT_SERVICE.apply(applyInfoDTO, memberId);

      InvalidDTO invalidDTO =
          result.equals(Word.SUCCESS) ? new InvalidDTO(Word.AVAILABLE)
              : new InvalidDTO(Word.UNAVAILABLE);

      String json = GSON.toJson(invalidDTO);

      JsonUtil.sendJSON(response, json);

    }//end of if
  }
}
