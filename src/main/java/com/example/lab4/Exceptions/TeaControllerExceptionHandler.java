package com.example.lab4.Exceptions;


import com.example.lab4.Controllers.TeaController;
import com.example.lab4.Models.Tea;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RestControllerAdvice(basePackages = "com.example.lab4.Controllers")
public @interface TeaControllerExceptionHandler {
}
