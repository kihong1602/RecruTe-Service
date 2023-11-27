package com.blanc.recrute.recruitment.service;

import static com.blanc.recrute.common.Count.ZERO;
import static com.blanc.recrute.common.Word.AVAILABLE;
import static com.blanc.recrute.common.Word.UNAVAILABLE;

import com.blanc.recrute.common.AptIdFactory;
import com.blanc.recrute.common.CookieManager;
import com.blanc.recrute.member.dto.ValidationDTO;
import com.blanc.recrute.recruitment.dao.RecruitDAO;
import com.blanc.recrute.recruitment.dto.ApplyDTO;
import com.blanc.recrute.recruitment.dto.ApplyInfoDTO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecruitmentApplicationService implements RecruitmentService {

  private final RecruitDAO recruitDAO = new RecruitDAO();

  private final Logger log = Logger.getLogger(RecruitmentApplicationService.class.getName());

  @Override
  public ValidationDTO applyRecruitment(HttpServletRequest request, ApplyInfoDTO applyInfoDTO) {
    Cookie authCookie = CookieManager.getCookie(request, "sid");

    if (authCookie != null) {
      String memberId = getMemberId(request, authCookie);

      Integer memberPk = recruitDAO.findMemberPk(memberId);
      String aptId = AptIdFactory.createAptId();

      return applyProcess(applyInfoDTO, aptId, memberPk);
    } else {
      log.log(Level.SEVERE, "쿠키가 존재하지않습니다.");
      throw new NullPointerException();
    }
  }

  private String getMemberId(HttpServletRequest request, Cookie authCookie) {
    HttpSession session = request.getSession();
    return (String) session.getAttribute(authCookie.getValue());
  }

  private ValidationDTO applyProcess(ApplyInfoDTO applyInfoDTO, String aptId, Integer memberPk) {
    ApplyDTO applyDto = new ApplyDTO.Builder().aptId(aptId)
                                              .recruitId(applyInfoDTO.getRecruitId())
                                              .memberId(memberPk)
                                              .build();
    Integer result = recruitDAO.apply(applyDto);

    return result != null && result > ZERO.getNumber() ? new ValidationDTO(AVAILABLE)
        : new ValidationDTO(UNAVAILABLE);
  }

}
