package com.hossi.recrute.common.auth;

import jakarta.servlet.http.Cookie;

import static com.hossi.recrute.common.auth.AuthType.COOKIE;

public class AuthCookie implements Authenticator {
    private final Cookie cookie;

    public AuthCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    @Override
    public boolean isActive() {
        return cookie.getMaxAge() > 0;
    }

    @Override
    public void setMaxAge(int age) {
        cookie.setMaxAge(age);
    }

    @Override
    public Object get() {
        return cookie;
    }

    @Override
    public AuthType getType() {
        return COOKIE;
    }

    @Override
    public String getValue() {
        return cookie.getValue();
    }
}
