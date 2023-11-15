package com.hossi.recrute.common.service.message;

import com.hossi.recrute.common.service.anno.CMN;
import com.hossi.recrute.common.service.anno.EXM;
import com.hossi.recrute.common.service.anno.MBR;
import com.hossi.recrute.common.service.anno.RCT;
import com.hossi.recrute.common.service.code.MemberCode;
import com.hossi.recrute.common.service.code.ServiceCode;
import com.hossi.recrute.common.service.code.ServiceCodeManager;
import com.hossi.recrute.common.service.code.ServicePrefix;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.lang.annotation.Annotation;
import java.util.Map;

public interface MessageCreator {
    static Message<String> create() {
        try {
            ServiceCode code = getServiceCode();
            return new Message<>(code, "");
        } catch (NullPointerException | ClassNotFoundException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    static ErrorMessage createNotAuthMessage() {
        return new ErrorMessage(MemberCode.MBR201);
    }


    static ErrorMessage createErrorMessage() {
        try {
            ServiceCode code = getServiceCode();
            return new ErrorMessage(code);
        } catch (NullPointerException | ClassNotFoundException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    static Message<Map<String, Object>> create(ResponseData responseData) {
        try {
            ServiceCode code = getServiceCode();
            return new Message<>(code, responseData.getData());
        } catch (NullPointerException | ClassNotFoundException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static ServiceCode getServiceCode() throws ClassNotFoundException, NoSuchMethodException {
        Annotation[] annotations = getAnnotations();
        for (Annotation anno : annotations) {
            if (anno instanceof CMN) {
                return createServiceCode(ServicePrefix.CMN, ((CMN) anno).value());
            } else if (anno instanceof MBR) {
                return createServiceCode(ServicePrefix.MBR, ((MBR) anno).value());
            } else if (anno instanceof RCT) {
                return createServiceCode(ServicePrefix.RCT, ((RCT) anno).value());
            } else if (anno instanceof EXM) {
                return createServiceCode(ServicePrefix.EXM, ((EXM) anno).value());
            }
        }

        return null;
    }

    private static Annotation[] getAnnotations() throws ClassNotFoundException, NoSuchMethodException {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length >= 4) {
            StackTraceElement caller = stackTraceElements[4];
            String className = caller.getClassName();
            String methodName = caller.getMethodName();
            return Class.forName(className)
                .getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class)
                .getAnnotations();
        }

        return new Annotation[0];
    }

    private static ServiceCode createServiceCode(ServicePrefix servicePrefix, String serviceNumber) {
        return ServiceCodeManager.getInstance().getServiceCode(servicePrefix, serviceNumber);
    }
}
