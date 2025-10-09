package com.github.satwiksanand.portfolioBackend.errors;

import com.github.satwiksanand.portfolioBackend.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleAllException(Exception ex){
        ErrorDto err = ErrorDto.builder().message(ex.getMessage()).build();
        return ResponseEntity.ok(err);
    }
}
