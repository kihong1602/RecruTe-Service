package com.hossi.recrute.common.filter;

import com.hossi.recrute.common.auth.AuthData;
import com.hossi.recrute.common.auth.Authenticator;
import com.hossi.recrute.common.auth.processor.AuthManager;
import com.hossi.recrute.common.auth.util.AuthStream;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

import static com.hossi.recrute.common.auth.AuthType.COOKIE;

@WebFilter(filterName = "AuthCheckFilter")
public class AuthCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Optional<Authenticator> authenticatorWrapper = AuthManager.renewAndGetIfAuth(COOKIE, new AuthStream(request, response));
        servletRequest.setAttribute("isAuth", false);
        if(authenticatorWrapper.isPresent()) {
            Authenticator authenticator = authenticatorWrapper.get();
            AuthData authData = AuthManager.getAuthData(authenticator, new AuthStream(request, response));
            if(authData != null && authData.isPresent()) {
                servletRequest.setAttribute("authenticator", authenticator.get());
                servletRequest.setAttribute("authData", authData);
                servletRequest.setAttribute("isAuth", true);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
