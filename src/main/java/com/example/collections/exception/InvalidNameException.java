package com.example.collections.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidNameException extends RuntimeException{
    public InvalidNameException(String name) {
        super("Invalid name: " + name);
    }

    public String getName(String name) {
        return name;
    }
}
