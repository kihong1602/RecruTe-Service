package com.hossi.recrute.common.auth.processor;

import com.hossi.recrute.common.auth.AuthCookie;
import com.hossi.recrute.common.auth.Authenticator;
import jakarta.servlet.http.Cookie;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

abstract class AuthProcessor {

    abstract protected Authenticator publishAuthenticator();
    abstract protected void renewAuthenticator(Authenticator authenticator);
    abstract protected void expireAuthenticator(Authenticator authenticator);
    abstract protected Authenticator findAuthenticator(Object object);

    static class CookieProcessor extends AuthProcessor {
        private static final CookieProcessor INSTANCE = new CookieProcessor();

        private CookieProcessor() {
        }

        public static CookieProcessor getINSTANCE() {
            return INSTANCE;
        }


        @Override
        protected Authenticator publishAuthenticator() {
            String uuid = String.valueOf(UUID.randomUUID());
            Cookie cookie = new Cookie("sid", uuid);
            cookie.setHttpOnly(true);
            cookie.setMaxAge(3600);
            return new AuthCookie(cookie);
        }

        @Override
        protected void renewAuthenticator(Authenticator authenticator) {
            authenticator.setMaxAge(3600);
        }

        @Override
        protected void expireAuthenticator(Authenticator authenticator) {
            authenticator.setMaxAge(0);
        }

        protected Authenticator findAuthenticator(Object cookies) {
            if(cookies != null) {
                Optional<Cookie> foundedCookie = Arrays.stream((Cookie[])cookies)
                    .filter(cookie -> cookie.getName().equals("sid"))
                    .findFirst();
                return foundedCookie.map(AuthCookie::new).orElse(null);
            }
            return null;
        }
    }


}
