package com.hossi.recrute.common.auth.processor;

import com.hossi.recrute.common.auth.Authenticator;
import com.hossi.recrute.common.auth.AuthType;

import java.util.Optional;

public class ProxyAuthProcessor {
    private static final AuthProcessor.CookieProcessor cookieProcessor = AuthProcessor.CookieProcessor.getINSTANCE();

    private ProxyAuthProcessor() {
    }

    static Optional<Authenticator> findAuth(AuthType authType, Object data) {
        return switch (authType) {
            case COOKIE -> Optional.ofNullable(cookieProcessor.findAuthenticator(data));
            default -> Optional.empty();
        };
    }

    static Authenticator publishAuth(AuthType authType) {
        switch (authType) {
            case COOKIE -> {
                return cookieProcessor.publishAuthenticator();
            }
            default -> {
                return null;
            }
        }
    }

    static void renewAuth(Authenticator authenticator) {
        AuthType type = authenticator.getType();
        switch (type) {
            case COOKIE -> {
                cookieProcessor.renewAuthenticator(authenticator);
            }
        }
    }

    static void expireAuth(Authenticator authenticator) {
        AuthType type = authenticator.getType();
        switch (type) {
            case COOKIE -> {
                cookieProcessor.expireAuthenticator(authenticator);
            }
        }
    }
}
