package com.hossi.recrute.common.mail;

public enum MailType {
    GOOGLE("google.", 7);

    private final String prefix;
    private final Integer num;

    MailType(String prefix, Integer num) {
        this.prefix = prefix;
        this.num = num;
    }

    public String getPrefix() {
        return prefix;
    }

    public Integer getNum() {
        return num;
    }
}
