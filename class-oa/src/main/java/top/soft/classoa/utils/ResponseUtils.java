package top.soft.classoa.utils;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/11/30 15:50
 */

@Setter
@Getter
public class ResponseUtils {
    private String code;
    private String message;
    private Map<String, Object> data = new LinkedHashMap<>();

    public ResponseUtils() {
        this.code = "0";
        this.message = "success";
    }

    public ResponseUtils(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseUtils put(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public String toJsonString() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}