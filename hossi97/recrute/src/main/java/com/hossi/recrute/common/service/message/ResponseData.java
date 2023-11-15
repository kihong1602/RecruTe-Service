package com.hossi.recrute.common.service.message;

import java.util.HashMap;
import java.util.Map;

public class ResponseData {
    private final Map<String, Object> data;

    public ResponseData(ResponseData.Builder builder) {
        data = builder.data;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public static class Builder {
        private final Map<String, Object> data;

        public Builder() {
            data = new HashMap<>();
        }

        public ResponseData.Builder set(String key, Object value) {
            data.put(key, value);
            return this;
        }

        public ResponseData build() {
            return new ResponseData(this);
        }
    }
}
