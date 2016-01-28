package com.beta.wheelsup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by mburns on 1/26/16.
 */

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Keyword")
public class CustomException extends Exception {

}
