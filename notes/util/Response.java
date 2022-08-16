package com.example.notes.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private String message;
    private int errorcode;
    private Object token;

    public Response(){

    }
}
