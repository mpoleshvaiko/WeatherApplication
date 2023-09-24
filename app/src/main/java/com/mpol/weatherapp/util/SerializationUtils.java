package com.mpol.weatherapp.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class SerializationUtils {
    private static final Gson gson = new Gson();

    public static String serialize(Object object) {
        return gson.toJson(object);
    }

    public static <T> T deserialize(String json, Class<T> type) {
        return gson.fromJson(json, type);
    }

    public static <T> List<T> deserializeList(String json, Class<T> type) {
        Type listType = TypeToken.getParameterized(List.class, type).getType();
        return gson.fromJson(json, listType);
    }
}
