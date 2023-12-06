package com.example.lab4.Exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TeaException extends Exception{
    private final HttpStatus httpStatus;
    private final String code;
    public TeaException(HttpStatus httpStatus, String code, String message){
        super(message);
        this.httpStatus = httpStatus;
        this.code = code;
    }

}
