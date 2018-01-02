package com.base.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by mengtian on 2018/1/1
 */
public class JSONUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T jsonToBean(String json, Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }

    public static String beanToJson(Object bean) throws JsonProcessingException {
        return mapper.writeValueAsString(bean);
    }
}
