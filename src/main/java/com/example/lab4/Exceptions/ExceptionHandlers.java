package com.example.lab4.Exceptions;

import com.example.lab4.DTO.ErrorDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(EmptyResponseException.class)
    public ErrorDTO emptyHandler(EmptyResponseException e) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(e.getCode());
        errorDTO.setMessage(e.getMessage());
        return errorDTO;
    }

    @ExceptionHandler(PostTeaException.class)
    public ErrorDTO handleException(PostTeaException e) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(e.getCode());
        errorDTO.setMessage(e.getMessage());
        return errorDTO;
    }

    @ExceptionHandler(WrongTeaIdException.class)
    public ErrorDTO wrongTeaIdHandler(WrongTeaIdException e) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(e.getCode());
        errorDTO.setMessage(e.getMessage());
        return errorDTO;
    }

    @ExceptionHandler(PutIdException.class)
    public ErrorDTO putIdHandler(PutIdException e) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(e.getCode());
        errorDTO.setMessage(e.getMessage());
        return errorDTO;
    }
}