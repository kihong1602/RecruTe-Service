package com.blanc.recrute.recruitment.controller;

import com.blanc.recrute.common.CookieManager;
import com.blanc.recrute.common.JsonUtil;
import com.blanc.recrute.common.URLParser;
import com.blanc.recrute.common.ViewResolver;
import com.blanc.recrute.member.dto.ValidationDTO;
import com.blanc.recrute.recruitment.dto.ApplyInfoDTO;
import com.blanc.recrute.recruitment.dto.DetailDTO;
import com.blanc.recrute.recruitment.service.RecruitmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RecruitController", value = "/recruitments/*")
public class RecruitmentController extends HttpServlet {

  private RecruitmentService recruitmentService = new RecruitmentService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Integer recruitId = URLParser.getLastURI(request);

    setRecruitmentDetails(request, recruitId);

    String path = "recruitment/rct-detail";
    ViewResolver.render(path, request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ApplyInfoDTO applyInfoDTO = JsonUtil.jsonParser(request, ApplyInfoDTO.class);

    String memberId = getMemberId(request);

    ValidationDTO validationDTO = recruitmentService.applyRecruitment(memberId, applyInfoDTO);

    JsonUtil.sendJSON(response, validationDTO);
  }

  private void setRecruitmentDetails(HttpServletRequest request, Integer recruitId) {

    DetailDTO detailDTO = recruitmentService.findRecruitmentDetailInfo(recruitId);

    request.setAttribute("detailDTO", detailDTO);
  }

  private String getMemberId(HttpServletRequest request) {
    Cookie authCookie = CookieManager.getCookie(request, "sid");
    if (authCookie != null) {
      HttpSession session = request.getSession();
      return (String) session.getAttribute(authCookie.getValue());
    } else {
      throw new NullPointerException("쿠키가 존재하지않습니다.");
    }

  }
}
