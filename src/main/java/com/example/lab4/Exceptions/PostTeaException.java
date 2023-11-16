package com.example.lab4.Exceptions;

import org.springframework.http.HttpStatus;

public class PostTeaException extends TeaException{
    public PostTeaException(String code, String message) {
        super(HttpStatus.BAD_REQUEST, code, message);
    }
}
