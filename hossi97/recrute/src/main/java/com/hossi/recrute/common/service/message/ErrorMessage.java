package com.hossi.recrute.common.service.message;

import com.hossi.recrute.common.service.code.ServiceCode;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessage {
    private static final Map<ServiceCode, String> errorMsgs = new HashMap<>();

    private final ServiceCode code;
    private final String description;
    private final String errorMsg;

    public ErrorMessage(ServiceCode code) {
        this.code = code;
        this.description = code.getDescription();
        this.errorMsg = errorMsgs.get(code);
    }

    public static void setErrorMsg(ServiceCode serviceCode, String message) {
        errorMsgs.put(serviceCode, message);
    }

    public static String getErrorMsg(ServiceCode serviceCode) {
        return errorMsgs.get(serviceCode);
    }
}
