package com.blanc.recrute.exam.controller;

import com.blanc.recrute.common.util.JsonUtil;
import com.blanc.recrute.common.util.URLParser;
import com.blanc.recrute.common.util.ViewResolver;
import com.blanc.recrute.exam.dto.ExaminationDTO;
import com.blanc.recrute.exam.dto.answer.AnswerData;
import com.blanc.recrute.exam.service.ExamManagementService;
import com.blanc.recrute.member.dto.ValidationDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "exam/*", value = "/exam/*")
public class ExaminationServlet extends HttpServlet {

  private ExamManagementService examService = new ExamManagementService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Integer examId = URLParser.getLastURI(request);

    List<ExaminationDTO> examList = examService.loadExamination(examId);

    request.setAttribute("ExamList", examList);
    request.setAttribute("size", examList.size());

    String path = "exam/examination";
    ViewResolver.render(path, request, response);
  }

  /**
   * 현재 exam table에 question, answer 컬럼이 종속되어 있으므로 답안을 DB에 저장할수 없습니다. 따라서 현재는 DAO까지 잘 전달되는지 확인을 해보았고, DB 재설계 후 답안을 DB에
   * insert 하는 로직으로 변경예정입니다.
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    AnswerData answerData = JsonUtil.jsonParser(request, AnswerData.class);

    ValidationDTO validationDTO = examService.saveExamination(answerData);

    JsonUtil.sendJSON(response, validationDTO);
  }
}
