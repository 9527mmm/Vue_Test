package com.zxk.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {
    }

    public static <T> T req2Bean(HttpServletRequest req, Class<T> cls) {
        String s = null;
        try {
            s = req.getReader().readLine();
            T t = str2Bean(s, cls);
            return t;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json格式的字符串转成指定类型的Bean对象
     *
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T str2Bean(String json, Class<T> cls) {
        T t = null;
        try {
            t = mapper.readValue(json, cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 将Json格式的字符串转成指定类型的集合（List/Map）
     *
     * @param json
     * @param typeReference
     * @param <T>
     * @return
     */
    public static <T> T str2ListOrMap(String json, TypeReference<T> typeReference) {
        T t = null;
        try {
            t = mapper.readValue(json, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 将对象转成对应格式的Json字符串
     *
     * @param obj
     * @return
     */
    public static String obj2Str(Object obj) {
        String s = null;
        try {
            s = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }
}
