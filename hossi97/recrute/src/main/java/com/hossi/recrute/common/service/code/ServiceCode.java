package com.hossi.recrute.common.service.code;

import java.util.Arrays;
import java.util.Map;

public interface ServiceCode {
    String getDescription();

    static void mapCodes(ServicePrefix prefix, Map<String, ServiceCode> codes) {
        switch (prefix) {
            case CMN:
                Arrays.stream(CommonCode.values()).forEach(code -> {
                    codes.putIfAbsent(code.name().substring(3), code);
                });
                break;
            case MBR:
                Arrays.stream(MemberCode.values()).forEach(code -> {
                    codes.putIfAbsent(code.name().substring(3), code);
                });
                break;
            case EXM:
                Arrays.stream(ExamCode.values()).forEach(code -> {
                    codes.putIfAbsent(code.name().substring(3), code);
                });
                break;
            case RCT:
                Arrays.stream(RecruitmentCode.values()).forEach(code -> {
                    codes.putIfAbsent(code.name().substring(3), code);
                });
        }
    }
}
