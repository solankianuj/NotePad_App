package com.example.notes.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class UserNotFound extends RuntimeException{
    private int statusCode;
    private String statusMessage;

    public UserNotFound(int statusCode, String statusMessage) {
        super(statusMessage);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
