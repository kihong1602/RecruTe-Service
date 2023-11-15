package com.hossi.recrute.member.controller;

import com.hossi.recrute.common.service.anno.MBR;
import com.hossi.recrute.common.http.JsonManager;
import com.hossi.recrute.common.service.message.Message;
import com.hossi.recrute.common.service.message.MessageCreator;
import com.hossi.recrute.common.servlet.HttpController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.google.common.net.MediaType.JSON_UTF_8;
import static jakarta.servlet.http.HttpServletResponse.SC_OK;

@WebServlet(name = "authServlet", value = "/auth")
public class AuthServlet extends HttpController {

    @Override @MBR(value = "201", description = "추가 권한 조회")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Message<String> message = MessageCreator.create();
        servletSetter()
            .setStatus(SC_OK, response)
            .setJson(JSON_UTF_8, JsonManager.toJson(message), response);
    }

}