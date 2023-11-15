package com.hossi.recrute.common.mybatis;

public enum ResultType {
    FAILURE("처리 실패"), SUCCESS("처리 성공");

    private final String description;

    ResultType(String description) {
        this.description = description;
    }

    public static ResultType getType(int value) {
        return (value == 0) ? FAILURE : SUCCESS;
    }

    public boolean equals(int result) {
        return (result == this.ordinal());
    }
}
