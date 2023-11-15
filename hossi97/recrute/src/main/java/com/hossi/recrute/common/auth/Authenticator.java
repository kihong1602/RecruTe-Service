package com.hossi.recrute.common.auth;

public interface Authenticator {
    Object get();
    String getValue();
    AuthType getType();
    boolean isActive();
    void setMaxAge(int age);
}
