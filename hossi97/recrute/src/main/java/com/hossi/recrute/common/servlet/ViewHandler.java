package com.hossi.recrute.common.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ViewHandler {
    void forward(String path, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
