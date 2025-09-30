package ru.alfabank.practice.vstanislavskiy.bankonboarding.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class ApplicationException extends RuntimeException {
    private String code;
    private String message;
    private Map<String,Object> metadata;
    private HttpStatus status;

    public ApplicationException(String code, String message, Map<String, Object> metadata, HttpStatus status, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
        this.metadata = metadata;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
