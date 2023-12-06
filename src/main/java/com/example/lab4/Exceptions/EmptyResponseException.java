package com.example.lab4.Exceptions;

import org.springframework.http.HttpStatus;

public class EmptyResponseException extends TeaException{
    public EmptyResponseException(int code, String message){
        super(HttpStatus.NO_CONTENT, String.valueOf(code), message);
    }
}
