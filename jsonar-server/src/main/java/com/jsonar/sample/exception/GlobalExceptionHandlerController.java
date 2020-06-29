package com.jsonar.sample.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerController {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerController.class);

    @ExceptionHandler(CoreException.class)
    public ResponseEntity<String> handleException(CoreException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

