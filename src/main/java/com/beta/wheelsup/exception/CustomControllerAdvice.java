package com.beta.wheelsup.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

/**
 * Created by mburns on 1/26/16.
 */
@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(CustomException.class)
    public String customeException(Exception e) {
        //handle and log exception
        return "error";
    }

    @ExceptionHandler(IOException.class)
    public String ioExceptionHandler(Exception e) {

        //handle and log exception
        return "error";
    }
}
