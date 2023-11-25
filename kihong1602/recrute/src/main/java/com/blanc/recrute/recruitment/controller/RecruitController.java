package com.blanc.recrute.recruitment.controller;

import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.SUCCESS;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.common.CookieManager;
import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.URLParser;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.common.Word;
import com.blanc.recrute.member.dto.InvalidDTO;
import com.blanc.recrute.recruitment.dto.ApplyInfoDTO;
import com.blanc.recrute.recruitment.dto.DetailDTO;
import com.blanc.recrute.recruitment.service.RecruitService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RecruitController", value = "/recruitments/*")
public class RecruitController extends HttpServlet {

  private final RecruitService RECRUIT_SERVICE = new RecruitService();

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
    ApplyInfoDTO applyInfoDTO = JsonUtil.jsonParser(request, ApplyInfoDTO.class);

    Cookie authCookie = CookieManager.getCookie(request, "sid");

    if (authCookie != null) {
      HttpSession session = request.getSession();
      String memberId = (String) session.getAttribute(authCookie.getValue());
      Word result = RECRUIT_SERVICE.apply(applyInfoDTO, memberId);

      InvalidDTO invalidDTO =
          result.equals(SUCCESS) ? new InvalidDTO(AVAILABLE) : new InvalidDTO(UNAVAILABLE);

      JsonUtil.sendJSON(response, invalidDTO);

    }
  }
}
