package com.lalalalz.web.common;

import com.lalalalz.application.util.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionRestController {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeExceptionHandler(final RuntimeException runtimeException) {
        return ResponseEntity.internalServerError()
                .body(runtimeException.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> businessExceptionHandler(final BusinessException businessException) {
        return ResponseEntity.badRequest()
                .body(businessException.getMessage());
    }
}
