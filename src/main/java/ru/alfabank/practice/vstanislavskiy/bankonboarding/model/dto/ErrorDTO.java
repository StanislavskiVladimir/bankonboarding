package ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto;

import java.util.Map;

public class ErrorDTO {
    private String code;
    private String message;
    private Map<String, Object> metadata;

    public ErrorDTO(String code, String message, Map<String, Object> metadata) {
        this.code = code;
        this.message = message;
        this.metadata = metadata;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }
}
