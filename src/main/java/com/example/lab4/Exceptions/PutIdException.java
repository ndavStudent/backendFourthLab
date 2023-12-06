package com.example.lab4.Exceptions;

import org.springframework.http.HttpStatus;

public class PutIdException extends TeaException{
    public PutIdException(String code, String message){
        super(HttpStatus.BAD_REQUEST, code, message);
    }
}
