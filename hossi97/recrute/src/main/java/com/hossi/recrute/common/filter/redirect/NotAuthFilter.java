package com.hossi.recrute.common.filter.redirect;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static jakarta.servlet.http.HttpServletResponse.SC_SEE_OTHER;

@WebFilter(filterName="NotAuthRedirectFilter")
public class NotAuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        boolean isAuth = (boolean) request.getAttribute("isAuth");
        if(!isAuth) {
            response.setStatus(SC_SEE_OTHER);
            response.setHeader("Location", "/");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}
