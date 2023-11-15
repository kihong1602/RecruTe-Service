package com.hossi.recrute.recruitment.controller;

import com.hossi.recrute.common.service.anno.RCT;
import com.hossi.recrute.common.servlet.HttpController;
import com.hossi.recrute.common.servlet.ViewResolver;
import com.hossi.recrute.recruitment.dto.RecruitmentDto;
import com.hossi.recrute.recruitment.service.RecruitmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static jakarta.servlet.http.HttpServletResponse.SC_NOT_FOUND;
import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@WebServlet(name = "recruitmentServlet", urlPatterns = "/recruitments/*")
public class RecruitmentServlet extends HttpController {
    private final RecruitmentService recruitmentService = new RecruitmentService();

    @Override @RCT(value = "001", description = "채용공고 상세 페이지 조회")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String requestURI = request.getRequestURI();
        String[] parsedURI = requestURI.split("recruitments/");
        String lastPiece = parsedURI[parsedURI.length - 1];
        if (isNumeric(lastPiece)) {
            Integer rctId = Integer.parseInt(lastPiece);
            RecruitmentDto recruitment = recruitmentService.getRecruitment(rctId);
            servletSetter()
                .setAttribute("recruitment", recruitment, request)
                .setAttribute("mainViewPath", ViewResolver.resolveMainViewPath("recruitment"), request)
                .setStatus(SC_OK, response)
                .forward(ViewResolver.getMainViewPath(), request, response);
        } else {
            servletSetter()
                .setAttribute("errorViewPath", ViewResolver.resolveErrorViewPath("err404"), request)
                .setStatus(SC_NOT_FOUND, response)
                .forward(ViewResolver.getErrorViewPath(), request, response);
        }
    }

    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
