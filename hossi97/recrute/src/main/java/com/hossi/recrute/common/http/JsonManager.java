package com.hossi.recrute.common.http;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonManager {
    private static final Gson gson = new Gson();

    public static JsonElement toJson(Object message) {
        return gson.toJsonTree(message);
    }

    public static <T> T fromJson(String json, Class<T> tClass) {
        return gson.fromJson(json, tClass);
    }

    public static JsonObject fromJson(String json) {
        return JsonParser.parseString(json).getAsJsonObject();
    }
}
