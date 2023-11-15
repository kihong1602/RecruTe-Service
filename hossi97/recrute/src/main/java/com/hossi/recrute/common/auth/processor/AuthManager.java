package com.hossi.recrute.common.auth.processor;

import com.hossi.recrute.common.auth.AuthData;
import com.hossi.recrute.common.auth.AuthType;
import com.hossi.recrute.common.auth.Authenticator;
import com.hossi.recrute.common.auth.util.AuthStream;

import java.util.Optional;

public interface AuthManager {
    static boolean renewIfAuth(AuthType authType, AuthStream authStream) {
        Optional<Authenticator> authenticator = findAuth(authType, authStream);
        authenticator.ifPresent(auth -> {
            if (auth.isActive() && authStream.checkSession(auth.getValue())) {
                renewAuth(auth);
                authStream.setAuthCookie(authType, auth);
            }
        });

        return authenticator.isPresent();
    }

    static Optional<Authenticator> renewAndGetIfAuth(AuthType authType, AuthStream authStream) {
        Optional<Authenticator> authenticator = findAuth(authType, authStream);
        authenticator.ifPresent(auth -> {
            if (auth.isActive() && authStream.checkSession(auth.getValue())) {
                renewAuth(auth);
                authStream.setAuthCookie(authType, auth);
            }
        });
        return authenticator;
    }

    static AuthData getAuthData(Authenticator authenticator, AuthStream authStream) {
        return authStream.getAuthData(authenticator);
    }

    static void changeAuthData(Authenticator authenticator, AuthData authData, AuthStream authStream) {
        authStream.setAuthSession(authenticator, authData);
    }

    static void grantAuth(AuthType authType, AuthData authData, AuthStream authStream) {
        authStream.addAuthCookieAndSession(authType, publishAuth(authType), authData);
    }

    static void expireAuth(Authenticator authenticator, AuthStream authStream) {
        expireAuth(authenticator);
        authStream.removeAuth(authenticator.getType(), authenticator);
    }

    private static Optional<Authenticator> findAuth(AuthType authType, AuthStream authStream) {
        return ProxyAuthProcessor.findAuth(authType, authStream.getRequestData(authType));
    }

    private static Authenticator publishAuth(AuthType authType) {
        return ProxyAuthProcessor.publishAuth(authType);
    }

    private static void renewAuth(Authenticator authenticator) {
        ProxyAuthProcessor.renewAuth(authenticator);
    }

    private static void expireAuth(Authenticator authenticator) {
        ProxyAuthProcessor.expireAuth(authenticator);
    }
}
