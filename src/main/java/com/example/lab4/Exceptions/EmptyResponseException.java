package com.example.lab4.Exceptions;

import org.springframework.http.HttpStatus;

public class EmptyResponseException extends TeaException{
    public EmptyResponseException(String code, String message){
        super(HttpStatus.NO_CONTENT, code, message);
    }
}
