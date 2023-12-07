package com.example.lab4.Exceptions;

import com.example.lab4.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = TeaControllerExceptionHandler.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(TeaException.class)
    public ErrorDTO emptyHandler(EmptyResponseException e) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(e.getCode());
        errorDTO.setMessage(e.getMessage());
        return errorDTO;
    }

}
