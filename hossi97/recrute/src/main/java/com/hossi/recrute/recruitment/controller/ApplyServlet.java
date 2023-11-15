package com.hossi.recrute.recruitment.controller;

import com.hossi.recrute.common.auth.AuthData;
import com.hossi.recrute.common.http.JsonManager;
import com.hossi.recrute.common.mybatis.ResultType;
import com.hossi.recrute.common.service.anno.RCT;
import com.hossi.recrute.common.service.message.ErrorMessage;
import com.hossi.recrute.common.service.message.Message;
import com.hossi.recrute.common.service.message.MessageCreator;
import com.hossi.recrute.common.servlet.HttpController;
import com.hossi.recrute.recruitment.dto.ApplicantReqDto;
import com.hossi.recrute.recruitment.service.RecruitmentService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.google.common.net.MediaType.JSON_UTF_8;
import static com.hossi.recrute.common.mybatis.ResultType.SUCCESS;
import static jakarta.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@WebServlet(name = "applyServlet", urlPatterns = "/recruitments/apply")
public class ApplyServlet extends HttpController {
    private final RecruitmentService recruitmentService = new RecruitmentService();

    @Override @RCT(value = "002", description = "채용공고 지원")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AuthData authData = getAuthData(request);
        Integer id = authData.getId();
        Integer rctId = JsonManager.fromJson(getJson(request)).get("rctId").getAsInt();
        ApplicantReqDto applicantReqDto = new ApplicantReqDto.Builder()
            .rctId(rctId)
            .id(id)
            .build();

        ResultType result = recruitmentService.applyRecruitment(applicantReqDto);
        if(result == SUCCESS) {
            Message<String> message = MessageCreator.create();
            servletSetter()
                .setStatus(SC_OK, response)
                .setJson(JSON_UTF_8, JsonManager.toJson(message), response);
        } else {
            ErrorMessage errorMessage = MessageCreator.createErrorMessage();
            servletSetter()
                .setStatus(SC_BAD_REQUEST, response)
                .setJson(JSON_UTF_8, JsonManager.toJson(errorMessage), response);
        }
    }
}
