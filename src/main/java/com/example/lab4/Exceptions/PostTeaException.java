package com.example.lab4.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpClientErrorException;

import java.nio.charset.Charset;

public class PostTeaException extends HttpClientErrorException{

    public PostTeaException(HttpStatusCode statusCode) {
        super(statusCode);
    }

    public PostTeaException(HttpStatusCode statusCode, String statusText) {
        super(statusCode, statusText);
    }

    public PostTeaException(HttpStatusCode statusCode, String statusText, byte[] body, Charset responseCharset) {
        super(statusCode, statusText, body, responseCharset);
    }

    public PostTeaException(HttpStatusCode statusCode, String statusText, HttpHeaders headers, byte[] body, Charset responseCharset) {
        super(statusCode, statusText, headers, body, responseCharset);
    }

    public PostTeaException(String message, HttpStatusCode statusCode, String statusText, HttpHeaders headers, byte[] body, Charset responseCharset) {
        super(message, statusCode, statusText, headers, body, responseCharset);
    }
}
