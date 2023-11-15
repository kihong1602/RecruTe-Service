package com.hossi.recrute.common.filter.error;

import com.hossi.recrute.common.http.JsonManager;
import com.hossi.recrute.common.service.message.ErrorMessage;
import com.hossi.recrute.common.service.message.MessageCreator;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.google.common.net.MediaType.JSON_UTF_8;
import static jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

@WebFilter(filterName = "AuthErrorFilter")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        boolean isAuth = (boolean) request.getAttribute("isAuth");
        if(isAuth) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ErrorMessage errorMessage = MessageCreator.createNotAuthMessage();
            String json = JsonManager.toJson(errorMessage).toString();
            response.setStatus(SC_UNAUTHORIZED);
            response.setContentType(JSON_UTF_8.toString());
            response.setContentLength(json.length());
            response.getWriter().write(json);
        }
    }

}


