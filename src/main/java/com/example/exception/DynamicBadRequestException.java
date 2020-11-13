package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DynamicBadRequestException extends Exception{

    private static final long serialVersionUID = 1L;

    public DynamicBadRequestException(String message)
    {
        super(message);
    }

}