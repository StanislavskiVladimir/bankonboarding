package ru.alfabank.practice.vstanislavskiy.bankonboarding.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.alfabank.practice.vstanislavskiy.bankonboarding.model.dto.ErrorDTO;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleException(ApplicationException exception){
        return new ResponseEntity<>(new ErrorDTO(exception.getCode(), exception.getMessage(), exception.getMetadata()),exception.getStatus());
    }
}
