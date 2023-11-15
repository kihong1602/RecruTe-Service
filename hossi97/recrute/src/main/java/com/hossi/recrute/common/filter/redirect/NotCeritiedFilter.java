package com.hossi.recrute.common.filter.redirect;

import com.hossi.recrute.common.auth.AuthData;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.hossi.recrute.member.vo.Certification.NON_CERTIFIED;
import static jakarta.servlet.http.HttpServletResponse.SC_SEE_OTHER;

@WebFilter(filterName="NotCertifiedRedirectFilter")
public class NotCeritiedFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        AuthData authData = (AuthData) request.getAttribute("authData");
        if(authData != null && authData.getCertification() == NON_CERTIFIED) {
            response.setStatus(SC_SEE_OTHER);
            response.setHeader("Location", "/");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}
