package com.example.lab4.Exceptions;

import org.springframework.http.HttpStatus;

public class WrongTeaIdException extends TeaException{
    public WrongTeaIdException(String code, String message){
        super(HttpStatus.BAD_REQUEST, code, message);
    }
}
