package ru.alfabank.practice.vstanislavskiy.bankonboarding.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApplicationException> handleException(ApplicationException exception){
        return new ResponseEntity<>(exception,exception.getStatus());
    }
}
