package com.example.reactive_web.exception;

import org.springframework.http.HttpStatus;

/**
 * @Auther: changzhaoliang
 * @Date: 2018/11/14 16:49
 * @Description:
 */
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private final String message;
    private final HttpStatus httpStatus;

//    public ResourceNotFoundException() {}

    public ResourceNotFoundException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
