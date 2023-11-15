package com.hossi.recrute.common.mail;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class MailConfig {
    private static final Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(Resources.getResourceAsStream("config/mail.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private MailConfig(){
    }

    public static MailInfo getMailInfo(MailType mailType) {
        return switch (mailType) {
            case GOOGLE -> new MailInfo(getProperties(mailType));
        };
    }

    private static Map<String, String> getProperties(MailType mailType) {
        return properties.entrySet().stream()
            .filter(entry -> entry.getKey().toString().startsWith(mailType.getPrefix()))
            .collect(Collectors.toMap(
                entry -> entry.getKey().toString().substring(mailType.getNum()),
                entry -> entry.getValue().toString()
            ));
    }
}
