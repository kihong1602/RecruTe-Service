package com.hossi.recrute.common.mail;

import java.util.Map;

public class MailInfo {
    private final String host;
    private final String email;
    private final String password;
    private final String port;
    private final String auth;
    private final String enable;

    public MailInfo(Map<String, String> properties) {
        this.host = properties.get("mail.smtp.host");
        this.email = properties.get("mail.smtp.email");
        this.password = properties.get("mail.smtp.password");
        this.port = properties.get("mail.smtp.port");
        this.auth = properties.get("mail.smtp.auth");
        this.enable = properties.get("mail.smtp.ssl.enable");
    }

    public String getHost() {
        return host;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPort() {
        return port;
    }

    public String getAuth() {
        return auth;
    }

    public String getEnable() {
        return enable;
    }

    public Object getTrust() {
        return host;
    }
}
